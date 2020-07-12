package com.zkzong.job.job.simple;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.zkzong.job.entity.Foo;
import com.zkzong.job.repository.FooRepository;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SpringSimpleJob implements SimpleJob {

    @Resource
    private FooRepository fooRepository;

    @Override
    public void execute(final ShardingContext shardingContext) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread.currentThread().getId(), "SIMPLE"));
        List<Foo> fooList = fooRepository.findByStatus("TODO");
        System.out.println(new Date() + "获取全部TODO数据：" + fooList);
        for (Foo foo : fooList) {
            System.out.println("foo = " + foo);
            System.out.println("开始时间：" + new Date());
            foo.setStatus("COMPLETED");
            fooRepository.save(foo);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
