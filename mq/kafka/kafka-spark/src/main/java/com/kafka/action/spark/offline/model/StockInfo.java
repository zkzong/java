package com.kafka.action.spark.offline.model;

import java.io.Serializable;

/**
 * Description: 股票基本信息封装类<br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class StockInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 股票名称
     */
    private String stockName;
    /**
     * 股票代码
     */
    private String stockCode;
    /**
     * 交易日期
     */
    private String tradeDate;
    /**
     * 当日最高价 --统计结果时记录统计周期内最高价
     */
    private double highPrice;
    /**
     * 当日最低价 --统计结果时记录统计周期内最低价
     */
    private double lowPrice;
    /**
     * 历史最低价对应的交易日期
     */
    private String lowPriceDate;
    /**
     * 历史最高价对应的交易日期
     */
    private String highPriceDate;

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public String getLowPriceDate() {
        return lowPriceDate;
    }

    public void setLowPriceDate(String lowPriceDate) {
        this.lowPriceDate = lowPriceDate;
    }

    public String getHighPriceDate() {
        return highPriceDate;
    }

    public void setHighPriceDate(String highPriceDate) {
        this.highPriceDate = highPriceDate;
    }

    @Override
    public String toString() {
        return "StockInfo [stockName=" + stockName + ", stockCode=" + stockCode + ", highPrice=" + highPrice + ", lowPrice=" + lowPrice + ", lowPriceDate=" + lowPriceDate
                + ", highPriceDate=" + highPriceDate + "]";
    }
}
