package com.zkzong.job.job.dataflow;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.zkzong.job.entity.Foo;
import com.zkzong.job.repository.FooRepository;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class SpringDataflowJob implements DataflowJob<Foo> {

    @Resource
    private FooRepository fooRepository;

    @Override
    public List<Foo> fetchData(final ShardingContext shardingContext) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread.currentThread().getId(), "DATAFLOW FETCH"));
        List<Foo> fooList = fooRepository.findByStatus("TODO");
        System.out.println(new Date() + "获取全部TODO数据：" + fooList);
        return fooList;

    }

    @Override
    public void processData(final ShardingContext shardingContext, final List<Foo> data) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread.currentThread().getId(), "DATAFLOW PROCESS"));
        for (Foo foo : data) {
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
