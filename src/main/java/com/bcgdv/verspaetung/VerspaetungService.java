package com.bcgdv.verspaetung;

import com.bcgdv.verspaetung.domain.AdjustedTime;
import com.bcgdv.verspaetung.domain.Delay;
import com.bcgdv.verspaetung.domain.Line;
import com.bcgdv.verspaetung.exception.LineNotFoundException;
import com.bcgdv.verspaetung.exception.StopNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bcgdv.verspaetung.repository.VerspaetungRepository;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VerspaetungService {
    @Autowired
    VerspaetungRepository repository;

    public VerspaetungService(VerspaetungRepository repository) {
        this.repository = repository;
    }

    public boolean isDelayed(int lineId) throws Exception {
        Line line;
        Optional<Line> lineOptional = repository.getLine(lineId);

        if (lineOptional.isPresent()) {
            line = lineOptional.get();
        } else {
            throw new LineNotFoundException("Line could not be found");
        }

        List<Delay> delays = repository.getDelays();
        Optional<Delay> delay = delays.stream()
                .filter(d -> d.getLineName().equalsIgnoreCase(line.getName()))
                .findAny();

        if (delay.isPresent()) {
            return true;
        }

        return false;
    }

    public int getNextLine(int stopId, LocalTime timeNow) throws StopNotFoundException, Exception {
        int lineId;
        List<AdjustedTime> linesWithAdjustedTime =
                repository.getLinesWithAdjustedTime(stopId);

        List<AdjustedTime> linesforGivenStop = linesWithAdjustedTime
                .stream()
                .filter(adjustedTime -> adjustedTime.getStopId() == stopId)
                .collect(Collectors.toList());

        if (linesforGivenStop.isEmpty()) {
            throw new StopNotFoundException("Stop cannot be found");
        }

        // LocalTime.isAfter does not include the current timestamp,
        // we assume that 10:08:00 is not after 10:08:00
        List<AdjustedTime> linesAfterNow = linesforGivenStop
                .stream()
                .filter(adjustedTime -> adjustedTime.getTimeAfterDelay().isAfter(timeNow))
                .collect(Collectors.toList());

        if (linesAfterNow.isEmpty()) {
            // return smallest value from linesforGivenStop
            lineId = linesforGivenStop
                    .stream()
                    .min(Comparator.comparing(AdjustedTime::getTimeAfterDelay))
                    .get().getLineId();
        } else {
            // return smallest value from linesAfterNow
            lineId = linesAfterNow
                    .stream()
                    .min(Comparator.comparing(AdjustedTime::getTimeAfterDelay))
                    .get().getLineId();
        }

        return lineId;
    }

    public List<Line> getVehicles(String time, int x, int y) throws Exception, StopNotFoundException {
        return repository.getLinesFor(time, x, y);
    }
}
