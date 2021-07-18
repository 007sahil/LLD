package com.stockExchange.Service.impl;

import com.stockExchange.Models.GenericLog;
import com.stockExchange.Models.StockExchangeLogger;
import com.stockExchange.Service.LogService;
import com.stockExchange.Service.RuleService;
import com.stockExchange.Service.TradingService;
import com.stockExchange.Models.TradingRequest;
import com.stockExchange.constants.RequestType;
import com.stockExchange.dao.StockPoolDao;
import com.stockExchange.dao.impl.StockPoolDaoImpl;
import com.stockExchange.factory.TradingRuleFactory;

import java.util.List;
import java.util.PriorityQueue;

public class TradingServiceImpl implements TradingService {

    private StockPoolDao stockPoolDao;
    private LogService logService;


    public TradingServiceImpl() {
        stockPoolDao = StockPoolDaoImpl.getInstance();
        logService = new LogServiceImpl();
    }

    @Override
    public void processRequest(TradingRequest currRequest) {

        RuleService service = TradingRuleFactory.getRuleService(currRequest.getStrategy());

        if(currRequest.getRequestType().equalsIgnoreCase(RequestType.BUY.getRequestType())) {
            currRequest =  processBuyRequest(currRequest, service);
        }else {
            currRequest =  processSellRequest(currRequest, service);
        }
        if(currRequest.getQuantity() > 0) {
            stockPoolDao.addRequest(currRequest);
        }
    }


    private TradingRequest processBuyRequest(TradingRequest currRequest, RuleService service) {

        List<TradingRequest> olderSellRequests = stockPoolDao.getAllRequests(RequestType.SELL.getRequestType(), currRequest.getStockName());

        olderSellRequests = service.provideDataAsPerRule(olderSellRequests);

        for(TradingRequest request : olderSellRequests) {

            if(currRequest.getPrice() >= request.getPrice()) {

                int quantity = 0;
                if (currRequest.getQuantity() > request.getQuantity()) {
                    quantity = request.getQuantity();
                    currRequest.setQuantity(currRequest.getQuantity() - request.getQuantity());
                    stockPoolDao.deleteRequest(request);
                } else {
                    quantity = currRequest.getQuantity();
                    request.setQuantity(request.getQuantity() - currRequest.getQuantity());
                    stockPoolDao.updateRequest(request);
                    currRequest.setQuantity(0);
                }
                logThisTrade(request, quantity, currRequest);
            }

            if(currRequest.getQuantity() == 0) {
                break;
            }

        }
        return currRequest;
    }

    /*  we should also process for the cases when buy request is there
        but not sell request, we need to store all those buy request and
        if any sell request is added which can fulfill that buy request
        should proceed for txn. Ignored as of now
     */
    private TradingRequest processSellRequest(TradingRequest currRequest, RuleService service) {
        return currRequest;
    }

    private void logThisTrade(TradingRequest sellRequest, int quantity, TradingRequest buyRequest) {
        GenericLog logger = new StockExchangeLogger(sellRequest.getTradingRequestID(), buyRequest.getTradingRequestID(),
                sellRequest.getPrice(), quantity);
        logService.flushLog(logger);
    }



}
