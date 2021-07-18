package com.stockExchange.factory;

import com.stockExchange.Service.impl.FirstInFirstOutRuleServiceImpl;
import com.stockExchange.Service.RuleService;

public class TradingRuleFactory {

    public static RuleService getRuleService(String name) {

        switch(name) {
            case "firstInFirstOut":
                return new FirstInFirstOutRuleServiceImpl();
            default:
                throw new RuntimeException("un expected rule");
        }
    }
}
