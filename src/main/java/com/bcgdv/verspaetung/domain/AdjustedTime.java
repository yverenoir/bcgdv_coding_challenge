package com.bcgdv.verspaetung.domain;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AdjustedTime {
    int lineId;
    String lineName;
    int stopId;
    String timeAfterDelay;

    public AdjustedTime(int lineId, int stopId, String timeAfterDelay) {
        this.lineId = lineId;
        this.stopId = stopId;
        this.timeAfterDelay = timeAfterDelay;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public int getStopId() {
        return stopId;
    }

    public void setStopId(int stopId) {
        this.stopId = stopId;
    }

    public LocalTime getTimeAfterDelay() {
        LocalTime localTime = LocalTime.parse(timeAfterDelay,
                DateTimeFormatter.ofPattern("HH:mm:ss"));

        return localTime;
    }

    public void setTimeAfterDelay(LocalTime timeAfterDelay) {
        this.timeAfterDelay = timeAfterDelay.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }
}
