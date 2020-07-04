package com.kafka.action.chapter6.producer;

import com.kafka.action.chapter6.dto.StockQuotationInfo;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;

import java.text.DecimalFormat;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Description:Producer多线程实现方式 <br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class MultiThreadProducer {

    private static final Logger LOG = Logger.getLogger(MultiThreadProducer.class);

    /**
     * 设置本实例生产消息的总数
     */
    private static final int MSG_SIZE = 1000000;

    /**
     * 主题名称
     */
    private static final String TOPIC = "stock-quotation";
    // private static final String TOPIC = "stock-quotation-partition";

    /**
     * kafka集群Broker列表
     */
    private static final String BROKER_LIST = "172.117.12.61:9092,172.117.12.62:9092,172.117.12.63:9092";

    /**
     * 线程数
     */
    private static final Integer THREADS_NUMS = 20;

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
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");
        // properties.put("partitioner.class",
        // "com.kafka.action.chapter7.StockPartitionor");
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
        quotationInfo.setStockCode(stockCode.toString());
        quotationInfo.setTradeTime(System.currentTimeMillis());
        quotationInfo.setStockName("股票-" + stockCode);
        return quotationInfo;
    }

    public static void main(String[] args) {
        ProducerRecord<String, String> record = null;
        StockQuotationInfo quotationInfo = null;
        ExecutorService executor = Executors
                .newFixedThreadPool(THREADS_NUMS);
        long current = System.currentTimeMillis();
        try {
            for (int i = 0; i < MSG_SIZE; i++) {
                quotationInfo = createQuotationInfo();
                record = new ProducerRecord<String, String>(TOPIC, null,
                        quotationInfo.getTradeTime(),
                        quotationInfo.getStockCode(), quotationInfo.toString());
                executor.submit(new KafkaProducerThread(producer, record));
            }
        } catch (Exception e) {
            LOG.error("Send message occurs exception", e);
        } finally {
            producer.close();
            executor.shutdown();
        }
        LOG.info("多线程发送" + MSG_SIZE + "条消息，用时：" + (System.currentTimeMillis() - current) + "毫秒");
    }

}
