package com.bcgdv.verspaetung.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Delay {
    @JsonProperty("line_name")
    private String lineName;
    private int delay;

    public Delay() {
    }

    public Delay(String lineName, int delay) {
        this.lineName = lineName;
        this.delay = delay;
    }

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
