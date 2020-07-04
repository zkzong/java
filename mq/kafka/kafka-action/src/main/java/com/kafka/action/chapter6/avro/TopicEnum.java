package com.kafka.action.chapter6.avro;

import org.apache.avro.specific.SpecificRecordBase;
import org.apache.commons.lang.StringUtils;

/**
 * Description:主题与类隐射枚举 <br/>
 *
 * @author moudaen
 * @version 1.0
 */
public enum TopicEnum {

    STOCK_QUOTATION_AVRO("stock-quotation-avro", new AvroStockQuotation());

    public String topicName;

    public SpecificRecordBase dataType;

    private TopicEnum(String topicName, SpecificRecordBase dataType) {
        this.topicName = topicName;
        this.dataType = dataType;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public SpecificRecordBase getDataType() {
        return dataType;
    }

    public void setDataType(SpecificRecordBase dataType) {
        this.dataType = dataType;
    }

    public static TopicEnum getEnum(String topicName) {
        if (StringUtils.isBlank(topicName)) {
            return null;
        }
        for (TopicEnum topic : values()) {
            if (StringUtils.equalsIgnoreCase(topic.getTopicName(), topicName)) {
                return topic;
            }
        }
        return null;
    }
}
