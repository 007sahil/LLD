package com.stockExchange;

import com.stockExchange.Models.GenericLog;
import com.stockExchange.Service.LogService;
import com.stockExchange.Service.impl.LogServiceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class StockExchangeApp {



    public static void main(String[] args) {

        GenericLog log = new GenericLog("********************* Welcome To Stock ExChange *********************");
        LogService service = new LogServiceImpl();
        service.flushLog(log);
        String file1 = "src/resources/stockeExchangeRequest.txt";
        String file2 = "src/resources/stockeExchangeRequest1.txt";

        proceedWithFileBasedInteraction(file1);
        log.setLog("\nproceed for new set of requests \n ");
        service.flushLog(log);
        proceedWithFileBasedInteraction(file2);
    }

    static void proceedWithFileBasedInteraction(String file) {
        File requestFile = new File(file);
        BufferedReader bufferReader = null;
        RequestProcessor processor = new RequestProcessor();
        String input = null;
        try {
            bufferReader = new BufferedReader(new FileReader(requestFile));
            while ((input = bufferReader.readLine()) != null) {
                input = input.trim();
                try {
                    processor.processTradingRequest(input);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}