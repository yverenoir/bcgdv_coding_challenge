package com.bcgdv.verspaetung.repository;

import com.bcgdv.verspaetung.domain.*;
import com.bcgdv.verspaetung.domain.reader.Reader;
import com.bcgdv.verspaetung.exception.StopNotFoundException;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class VerspaetungRepository {
    public List<Delay> getDelays() {
        return Reader.readDelay();
    }

    public List<Line> getLines() {
        return Reader.readLines();
    }

    public List<Stop> getStops() {
        return Reader.readStop();
    }

    public List<Time> getTimes() {
        return Reader.readTimes();
    }

    public Optional<Line> getLine(int lineId) {
        List<Line> lines = getLines();
        Optional<Line> line = lines.stream().filter(l -> l.getId() == lineId).findFirst();
        return line;
    }

    // Returns an updated time table considering the delay
    public List<AdjustedTime> getLinesWithAdjustedTime() {
        List<Time> times = getTimes();
        List<Delay> delays = getDelays();
        List<Line> lines = getLines();

        List<AdjustedTime> adjustedTimeList = new ArrayList<>();

        for(Time time: times){
            adjustedTimeList.add(
                    new AdjustedTime(time.getLineId(), time.getStopId(), LocalTime.parse(time.getTime())));
        }

        // join lines with times via lineId to add lineName
        adjustedTimeList
                .forEach(adjustedTime ->
                        adjustedTime.setLineName(
                lines.stream()
                        .filter(line -> line.getId() == adjustedTime.getLineId())
                        .findFirst()
                        .orElse(new Line(-1, ""))
                        .getName()
        ));

        // join adjustedTime with delays via lineName to add delay
        adjustedTimeList
                .forEach(adjustedTime ->
                        adjustedTime.setTimeAfterDelay(
                                adjustedTime.getTimeAfterDelay().plusMinutes(
                                delays.stream()
                                        .filter(delay -> delay.getLineName().equalsIgnoreCase(adjustedTime.getLineName()))
                                        .findFirst()
                                        .orElse(new Delay(null, 0))
                                        .getDelay()
                        )));

        return adjustedTimeList;
    }

    public List<Line> getLinesFor(String time, int x, int y) {
        List<Time> times = getTimes();
        List<Stop> stops = getStops();
        List<Line> lines = getLines();

        // findAny is used because we assume that for
        // each coordinate we only have one stop
        Optional<Stop> stopOptional = stops.stream()
                .filter(stop -> stop.getX() == x && stop.getY() == y)
                .findAny();

        stopOptional.orElseThrow(() -> new StopNotFoundException("Stop cannot be found"));

        int stopId = stopOptional.get().getId();

        List<Integer> lineIds = times.stream()
                .filter(t -> t.getStopId() == stopId)
                .filter(t -> t.getTime().equalsIgnoreCase(time))
                .map(Time::getLineId)
                .collect(Collectors.toList());

        return lines.stream()
                .filter(line -> lineIds.contains(line.getId()))
                .collect(Collectors.toList());
    }
}
