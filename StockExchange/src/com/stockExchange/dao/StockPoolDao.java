package com.stockExchange.dao;

import com.stockExchange.Models.TradingRequest;

import java.util.List;

public interface StockPoolDao {

    public List<TradingRequest> getAllRequests(String type, String stockName);
    public void addRequest(TradingRequest request);
    public void updateRequest(TradingRequest request);

    public void deleteRequest(TradingRequest request);

}
