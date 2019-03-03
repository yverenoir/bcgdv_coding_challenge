package com.bcgdv.verspaetung.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Line {
    @JsonProperty("line_id")
    private int id;
    @JsonProperty("line_name")
    private String name;

    public Line() {
    }

    public Line(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
