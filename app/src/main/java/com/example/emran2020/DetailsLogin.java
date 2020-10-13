package com.example.emran2020;

public class DetailsLogin {
    public String id;
    public int count;

    public DetailsLogin() {
    }

    public DetailsLogin(String id) {
        this.id = id;
        count++;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


