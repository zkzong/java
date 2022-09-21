package org.example.simple;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: zkzong
 * @Date: 2019/11/8
 */
public class MySimpleJob implements SimpleJob {
    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println(String.format("分片项 ShardingItem: %s | 运行时间: %s | 线程ID: %s | 分片参数: %s ",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()),
                Thread.currentThread().getId(), shardingContext.getShardingParameter()));
    }
}
