package com.bcgdv.verspaetung.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "lineId"})
public class Vehicle {
    @JsonProperty
    int id;
    @JsonProperty
    int lineId;

    public Vehicle(int id, int lineId) {
        this.id = id;
        this.lineId = lineId;
    }

    public Vehicle() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }
}
