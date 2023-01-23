package com.improve10x.improveenglish10x.models;

import java.io.Serializable;

public class Preposition implements Serializable {
    public String value;
    public String teluguValue;
    public String type;

    public Preposition() {}

    public Preposition(String value, String teluguValue, String type) {
        this.value = value;
        this.teluguValue = teluguValue;
        this.type = type;
    }

    @Override
    public String toString() {
        return value + " " + teluguValue;
    }
}
