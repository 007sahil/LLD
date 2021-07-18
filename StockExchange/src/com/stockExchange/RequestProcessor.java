package com.stockExchange;

import com.stockExchange.Models.TradingRequest;
import com.stockExchange.Service.TradingService;
import com.stockExchange.Service.impl.TradingServiceImpl;
import com.stockExchange.constants.RequestType;

import java.time.LocalTime;

public class RequestProcessor {

    TradingService service;

    public RequestProcessor() {
        service = new TradingServiceImpl();
    }

    public void processTradingRequest(String input) {

        String[] request = input.split(" ");

        /* can be user input for the strategy */
        String strategy = "firstInFirstOut";

        double price = Double.parseDouble(request[5]);
        int quantity = Integer.parseInt(request[4]);
        TradingRequest tradingRequest = new TradingRequest(request[0], request[2], price, quantity, LocalTime.now(), strategy, request[3]);
        service.processRequest(tradingRequest);
    }
}
