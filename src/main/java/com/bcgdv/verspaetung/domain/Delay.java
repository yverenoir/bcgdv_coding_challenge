package com.bcgdv.verspaetung.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "lineName", "delay"})
public class Delay {
    @JsonProperty
    String lineName;
    @JsonProperty
    int delay;

    public Delay() {
    }

//    public Delay(String lineName, String delay) {
//        this.lineName = lineName;
//        this.delay = delay;
//    }
//
    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
