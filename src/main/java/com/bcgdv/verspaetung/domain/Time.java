package com.bcgdv.verspaetung.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "lineId", "stopId", "timeAfterDelay"})
public class Time {
    @JsonProperty
    int lineId;
    @JsonProperty
    int stopId;
    @JsonProperty
    String time;

    public Time() {
    }

    public Time(int lineId, int stopId, String time) {
        this.lineId = lineId;
        this.stopId = stopId;
        this.time = time;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
