package com.kafka.action.chapter6.producer;

import com.kafka.action.chapter6.avro.AvroSerializer;
import com.kafka.action.chapter6.avro.AvroStockQuotation;
import com.kafka.action.chapter6.avro.TopicEnum;
import org.apache.commons.lang.StringUtils;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.log4j.Logger;

import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;

/**
 * Description:自定义avro序列化消息生产者 <br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class AvroQuotationProducer {

    private static final Logger LOG = Logger.getLogger(AvroQuotationProducer.class);
    // kafka集群
    private static final String BROKER_LIST = "127.0.0.1:9092,172.117.12.61:9092,172.117.12.62:9092,172.117.12.63:9092";

    private static KafkaProducer<String, AvroStockQuotation> producer = null;

    static {
        // 1.构造用于实例化KafkaProducer的Properties信息
        Properties configs = initConfig();
        // 2.初始化一个KafkaProducer
        producer = new KafkaProducer<String, AvroStockQuotation>(configs);
    }

    /**
     * 初始化kafka配置
     *
     * @return
     */
    private static Properties initConfig() {
        Properties properties = new Properties();
        // kafka broker列表
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BROKER_LIST);
        // 设置序列化类
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                AvroSerializer.class.getName());
        return properties;
    }

    /**
     * 生产股票行情信息
     *
     * @return
     */
    private static AvroStockQuotation createQuotationInfo() {
        AvroStockQuotation quotationInfo = new AvroStockQuotation();
        // 随机产生1到10之间的整数，然后与600100相加组成股票代码
        Random r = new Random();
        Integer stockCode = 600100 + r.nextInt(10);
        // 随机产生一个0到1之间的浮点数
        float random = (float) Math.random();
        // 设置涨跌规则
        if (random / 2 < 0.5) {
            random = -random;
        }
        DecimalFormat decimalFormat = new DecimalFormat(".00");// 设置保存两位有效数字
        quotationInfo.setCurrentPrice(Float.valueOf(decimalFormat
                .format(11 + random)));// 设置最新价在11元浮动
        quotationInfo.setPreClosePrice(11.80f);// 设置昨日收盘价为固定值
        quotationInfo.setOpenPrice(11.5f);// 设置开盘价
        quotationInfo.setLowPrice(10.5f);// 设置最低价,并不考虑10%限制,以前当价前是否已是最低价
        quotationInfo.setHighPrice(12.5f);// 设置最高价,并不考虑10%限制,以前当价前是否已是最高价
        quotationInfo.setStockCode(stockCode.toString());
        quotationInfo.setTradeTime(System.currentTimeMillis());
        quotationInfo.setStockName("股票-" + stockCode);
        return quotationInfo;
    }

    public static void sendMsg(TopicEnum topic, AvroStockQuotation message) {
        if (null == message) {
            return;
        }
        if (StringUtils.equals(topic.getDataType().getClass().getName(),
                message.getClass().getName())) {//
            ProducerRecord<String, AvroStockQuotation> record = new ProducerRecord<String, AvroStockQuotation>(
                    topic.getTopicName(), (String) message.getStockCode(),
                    message);
            producer.send(record, new Callback() {

                @Override
                public void onCompletion(RecordMetadata metaData,
                                         Exception exception) {
                    if (null != exception) {// 发送异常记录异常信息
                        LOG.error("Send message occurs exception.", exception);
                    }
                    if (null != metaData) {
                        LOG.info(String.format("offset:%s,partition:%s",
                                metaData.offset(), metaData.partition()));
                    }
                }

            });
        }

    }

    public static void main(String[] args) {

        try {
            int num = 0;
            // 设置实例生产消息的总数
            int msgSize = 10;
            AvroStockQuotation quotationInfo = null;
            for (int i = 0; i < msgSize; i++) {
                quotationInfo = createQuotationInfo();
                sendMsg(TopicEnum.STOCK_QUOTATION_AVRO, quotationInfo);
//				if (num++ % 10 == 0) {
//					Thread.sleep(2000L);// sleep2秒
//				}

            }
        } catch (Exception e) {
            LOG.error("Send message occurs exception", e);
        } finally {
            producer.close();
        }
    }

}
