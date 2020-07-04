package com.kafka.action.chapter7.streams;

import org.apache.kafka.streams.kstream.Windowed;
import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;

/**
 * Description: 自定义Processor完成黑名单处理<br/>
 *
 * @author moudaen
 * @version 1.0
 */
public class IpBlackListProcessor implements Processor<Windowed<String>, Long> {

    @Override
    public void init(ProcessorContext context) {

    }

    @Override
    public void process(Windowed<String> key, Long value) {
        System.out.println("ip:" + key.key() + "被加入到黑名单,请求次数为:" + value);

    }

    @Override
    public void punctuate(long timestamp) {

    }

    @Override
    public void close() {

    }
}
