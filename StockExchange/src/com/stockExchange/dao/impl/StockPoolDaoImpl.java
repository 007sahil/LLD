package com.stockExchange.dao.impl;

import com.stockExchange.Models.TradingRequest;
import com.stockExchange.dao.StockPoolDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StockPoolDaoImpl implements StockPoolDao {

    List<TradingRequest> tradingRequests;

    private static StockPoolDaoImpl stockPoolDaoImpl;

    private StockPoolDaoImpl() {
        tradingRequests = new ArrayList<>();
    }

    /* singleton pattern */
    public static StockPoolDaoImpl getInstance(){

        if(stockPoolDaoImpl == null) {
            stockPoolDaoImpl = new StockPoolDaoImpl();
        }
        return stockPoolDaoImpl;
    }


    @Override
    public List<TradingRequest> getAllRequests(String type, String stockName) {
        return tradingRequests.stream().filter(r -> r.getRequestType().equalsIgnoreCase(type)
                                    && r.getStockName().equalsIgnoreCase(stockName)).collect(Collectors.toList());
    }

    @Override
    public void addRequest(TradingRequest request) {
        tradingRequests.add(request);
    }

    @Override
    public void updateRequest(TradingRequest updatedRequest) {
        for(TradingRequest request : tradingRequests) {
            if(updatedRequest.equals(request)) {
                request.setQuantity(updatedRequest.getQuantity());
                break;
            }
        }
    }

    @Override
    public void deleteRequest(TradingRequest updatedRequest) {
        tradingRequests.remove(updatedRequest);
    }

}
