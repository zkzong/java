package com.zkzong.job.job.dataflow;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.zkzong.job.constant.Status;
import com.zkzong.job.entity.Foo;
import com.zkzong.job.repository.FooRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JavaDataflowJob implements DataflowJob<Foo> {

    @Autowired
    private FooRepository fooRepository;

    @Override
    public List<Foo> fetchData(final ShardingContext shardingContext) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread.currentThread().getId(), "DATAFLOW FETCH"));
        return fooRepository.findAll();
    }

    @Override
    public void processData(final ShardingContext shardingContext, final List<Foo> data) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread.currentThread().getId(), "DATAFLOW PROCESS"));
        for (Foo foo : data) {
            foo.setStatus(Status.COMPLETED.toString());
            fooRepository.save(foo);
        }
    }
}
