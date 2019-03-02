package com.bcgdv.verspaetung.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "id", "x", "y"})
public class Stop {
    @JsonProperty
    int id;
    @JsonProperty
    int x;
    @JsonProperty
    int y;

    public Stop() {
    }
//
//    public Stop(int id, int x, int y) {
//        this.id = id;
//        this.x = x;
//        this.y = y;
//    }
//
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
