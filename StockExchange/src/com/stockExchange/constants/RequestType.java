package com.stockExchange.constants;

public enum RequestType {

    BUY("buy"),
    SELL("sell");

    private String requestType;

    private RequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequestType() {
        return requestType;
    }
}
