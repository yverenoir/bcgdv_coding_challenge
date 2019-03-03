package com.bcgdv.verspaetung.domain;

import org.apache.tomcat.jni.Local;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

//    public LocalTime getTimeAfterDelay() {
//        LocalTime localTime = LocalTime.parse(timeAfterDelay,
//                DateTimeFormatter.ofPattern("HH:mm:ss"));
//
//        return localTime;
//    }
//
//    public void setTimeAfterDelay(LocalTime timeAfterDelay) {
//        this.timeAfterDelay = timeAfterDelay.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
//    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }
}
