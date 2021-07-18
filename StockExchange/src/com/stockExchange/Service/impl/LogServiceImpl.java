package com.stockExchange.Service.impl;

import com.stockExchange.Models.GenericLog;
import com.stockExchange.Service.LogService;

public class LogServiceImpl implements LogService {

    @Override
    public void flushLog(GenericLog log) {
        /* can be extended for different log destination
         terminal, kibana etc */
        System.out.println(log.toString());
    }
}
