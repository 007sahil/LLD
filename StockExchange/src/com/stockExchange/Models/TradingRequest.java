package com.stockExchange.Models;

import java.time.LocalTime;

public class TradingRequest {

    String tradingRequestID;
    String stockName;
    int quantity;
    LocalTime dateTime;
    double price;
    String strategy;

    public TradingRequest(String tradingRequestID, String stockName, double price, int quantity, LocalTime dateTime, String strategy, String requestType) {
        this.tradingRequestID = tradingRequestID;
        this.stockName = stockName;
        this.quantity = quantity;
        this.dateTime = dateTime;
        this.price = price;
        this.strategy = strategy;
        this.requestType = requestType;
    }



    public String getTradingRequestID() {
        return tradingRequestID;
    }

    public void setTradingRequestID(String tradingRequestID) {
        this.tradingRequestID = tradingRequestID;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    java.lang.String requestType;


    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(String strategy) {
        this.strategy = strategy;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalTime dateTime) {
        this.dateTime = dateTime;
    }


    @Override
    public String toString() {
        return "TradingRequest{" +
                "tradingRequestID='" + tradingRequestID + '\'' +
                ", stockName='" + stockName + '\'' +
                ", quantity=" + quantity +
                ", dateTime=" + dateTime +
                ", price=" + price +
                ", strategy='" + strategy + '\'' +
                ", requestType='" + requestType + '\'' +
                '}';
    }
}
