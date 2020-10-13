package com.example.emran2020;

public class processingMessage extends messages {

    public String g________Process;


    public processingMessage(String a________Date, String b________Id, String c________FirstName,
                             String d________LastName, String e________Phone, String f________content, String g________Process) {
        super ( a________Date, b________Id, c________FirstName, d________LastName, e________Phone, f________content );
        this.g________Process = g________Process;
    }

    public processingMessage() {
    }


    public String getG________Process() {
        return g________Process;
    }

    public void setG________Process(String g________Process) {
        this.g________Process = g________Process;
    }
}

