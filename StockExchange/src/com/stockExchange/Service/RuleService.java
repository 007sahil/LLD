package com.stockExchange.Service;

import com.stockExchange.Models.TradingRequest;

import java.util.List;

public interface RuleService {

    public List<TradingRequest> provideDataAsPerRule(List<TradingRequest> request);

}
