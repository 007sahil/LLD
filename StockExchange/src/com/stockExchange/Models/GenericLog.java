package com.stockExchange.Models;

public class GenericLog {

    String log;
    public GenericLog() {

    }
    public GenericLog(String log) {
        this.log = log;
    }

    @Override
    public String toString() {
        return log;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
