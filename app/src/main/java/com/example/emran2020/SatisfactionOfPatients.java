package com.example.emran2020;

public class SatisfactionOfPatients {

    public String id;
    public int value;

    public SatisfactionOfPatients() {
    }

    public SatisfactionOfPatients(String id, int value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}



