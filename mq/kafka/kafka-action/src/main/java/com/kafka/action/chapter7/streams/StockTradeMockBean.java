package com.kafka.action.chapter7.streams;

public class StockTradeMockBean {

    static public class StockQuotation {
        /**
         * 股票代码
         */
        public String secCode;

        /**
         * 当前价
         */
        public float curruntPrice;
    }

    static public class UserEntrust {
        /**
         * 股票代码
         */
        public String secCode;

        /**
         * 用户id
         */
        public String userId;

        /**
         * 委托价
         */
        public float entrustPrice;
    }
}
