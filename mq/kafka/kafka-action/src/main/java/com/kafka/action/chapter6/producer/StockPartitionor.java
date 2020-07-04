package com.kafka.action.chapter6.producer;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.log4j.Logger;

import java.util.Map;

/**
 * Description: 自定义Partitioner<br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class StockPartitionor implements Partitioner {

    private static final Logger LOG = Logger.getLogger(StockPartitionor.class);

    /**
     * 分区数
     */
    private static final Integer PARTITIONS = 6;

    @Override
    public void configure(Map<String, ?> arg0) {

    }

    @Override
    public void close() {

    }

    /**
     * 根据股票代码最后一位与分区总长度取模来做为分区分配的策略
     */
    @Override
    public int partition(String topic, Object key, byte[] keyBytes,
                         Object value, byte[] valueBytes, Cluster cluster) {
        if (null == key) {
            return 0;
        }
        String stockCode = String.valueOf(key);
        try {
            int partitionId = Integer.valueOf(stockCode.substring(stockCode
                    .length() - 2)) % PARTITIONS;
            return partitionId;
        } catch (NumberFormatException e) {
            LOG.error("Parse message key occurs exception,key:" + stockCode, e);
            return 0;
        }
    }

}
