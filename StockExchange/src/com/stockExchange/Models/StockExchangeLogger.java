package com.stockExchange.Models;

public class StockExchangeLogger extends GenericLog{

    private String sellTradeRequestID;
    private String buyTradeRequestID;
    private Double sellingPrice;
    private int tradeQuantity;

    @Override
    public String toString() {
        return  sellTradeRequestID + " " + tradeQuantity + " " + sellingPrice +
                " " + buyTradeRequestID;
    }

    public StockExchangeLogger(String sellTradeRequestID, String buyTradeRequestID, Double sellingPrice, int tradeQuantity) {
        super();
        this.sellTradeRequestID = sellTradeRequestID;
        this.buyTradeRequestID = buyTradeRequestID;
        this.sellingPrice = sellingPrice;
        this.tradeQuantity = tradeQuantity;
    }

    public String getSellTradeRequestID() {
        return sellTradeRequestID;
    }

    public void setSellTradeRequestID(String sellTradeRequestID) {
        this.sellTradeRequestID = sellTradeRequestID;
    }

    public String getBuyTradeRequestID() {
        return buyTradeRequestID;
    }

    public void setBuyTradeRequestID(String buyTradeRequestID) {
        this.buyTradeRequestID = buyTradeRequestID;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getTradeQuantity() {
        return tradeQuantity;
    }

    public void setTradeQuantity(int tradeQuantity) {
        this.tradeQuantity = tradeQuantity;
    }
}
