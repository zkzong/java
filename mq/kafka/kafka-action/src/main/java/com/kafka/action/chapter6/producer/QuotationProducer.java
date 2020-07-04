package com.kafka.action.chapter6.producer;

import com.kafka.action.chapter6.dto.StockQuotationInfo;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.log4j.Logger;

import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;

/**
 * Description: <br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class QuotationProducer {

    private static final Logger LOG = Logger.getLogger(QuotationProducer.class);
    // 设置实例生产消息的总数
    private static final int MSG_SIZE = 1000000;
    // 主题名称
    private static final String TOPIC = "stock-quotation";
    // private static final String TOPIC = "stock-quotation-partition";
    // kafka集群
    private static final String BROKER_LIST = "127.0.0.1:9092";

    private static KafkaProducer<String, String> producer = null;

    static {
        // 1.构造用于实例化KafkaProducer的Properties信息
        Properties configs = initConfig();
        // 2.初始化一个KafkaProducer
        producer = new KafkaProducer<String, String>(configs);
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
                StringSerializer.class.getName());
        //设置分区器类
        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,
                StockPartitionor.class.getName());
        return properties;
    }

    /**
     * 生产股票行情信息
     *
     * @return
     */
    private static StockQuotationInfo createQuotationInfo() {
        StockQuotationInfo quotationInfo = new StockQuotationInfo();
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

    public static void main(String[] args) {

        ProducerRecord<String, String> record = null;
        StockQuotationInfo quotationInfo = null;
        long current = System.currentTimeMillis();
        try {
            int num = 0;
            for (int i = 0; i < MSG_SIZE; i++) {
                quotationInfo = createQuotationInfo();
                record = new ProducerRecord<String, String>(TOPIC, null,
                        quotationInfo.getTradeTime(),
                        quotationInfo.getStockCode(), quotationInfo.toString());
                // producer.send(record);// 异步发送消息
                // 发送消息时指定一个callback,并覆盖onCompletion()方法，在成功发送后获取消息的偏移量及分区
                producer.send(record, new Callback() {

                    @Override
                    public void onCompletion(RecordMetadata metaData,
                                             Exception exception) {
                        if (null != exception) {// 发送异常记录异常信息
                            LOG.error("Send message occurs exception.",
                                    exception);
                        }
                        if (null != metaData) {
                            LOG.info(String.format("offset:%s,partition:%s",
                                    metaData.offset(), metaData.partition()));
                        }
                    }

                });
                if (num++ % 10 == 0) {
                    Thread.sleep(2000L);// sleep2秒
                }

            }
        } catch (Exception e) {
            LOG.error("Send message occurs exception", e);
        } finally {
            producer.close();
        }
        LOG.info("单线程发送" + MSG_SIZE + "条消息，用时：" + (System.currentTimeMillis() - current) + "毫秒");
    }
}
