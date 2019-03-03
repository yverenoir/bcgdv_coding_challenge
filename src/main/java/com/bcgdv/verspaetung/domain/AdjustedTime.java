package com.bcgdv.verspaetung.domain;

import java.time.LocalTime;

public class AdjustedTime {
    private int lineId;
    private String lineName;
    private int stopId;
    private LocalTime timeAfterDelay;

    public LocalTime getTimeAfterDelay() {
        return timeAfterDelay;
    }

    public void setTimeAfterDelay(LocalTime timeAfterDelay) {
        this.timeAfterDelay = timeAfterDelay;
    }

    public AdjustedTime(int lineId, int stopId, LocalTime timeAfterDelay) {
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

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }
}
