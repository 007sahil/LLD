package com.stockExchange.Service.impl;

import com.stockExchange.Models.TradingRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FirstInFirstOutRuleServiceImpl extends RuleServiceImpl {

    /*
    the job of this class is just to apply the rule on the data from database.
    database should not store data as per the rule, as different rules, can be
    there, then we need to store replicated data as per each rule.
     */
    @Override
    public List<TradingRequest> provideDataAsPerRule(List<TradingRequest> requests) {

        Queue<TradingRequest> queue = new PriorityQueue<>((o1, o2) -> {

            if(o1.getPrice() == o2.getPrice()) {
                o1.getDateTime().compareTo(o2.getDateTime());
            }
            return Double.compare(o1.getPrice(), o2.getPrice());
        });

        queue.addAll(requests);
        List<TradingRequest> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }
}
