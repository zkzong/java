package com.zkzong.job.job.simple;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.zkzong.job.fixture.entity.Foo;
import com.zkzong.job.fixture.repository.FooRepository;
import com.zkzong.job.fixture.repository.FooRepositoryFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class JavaSimpleJob implements SimpleJob {

    private FooRepository fooRepository = FooRepositoryFactory.getFooRepository();

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()),
                Thread.currentThread().getId(), "SIMPLE"));
        List<Foo> data = fooRepository.findTodoData(shardingContext.getShardingParameter(), 10);
        for (Foo each : data) {
            fooRepository.setCompleted(each.getId());
        }
    }
}
