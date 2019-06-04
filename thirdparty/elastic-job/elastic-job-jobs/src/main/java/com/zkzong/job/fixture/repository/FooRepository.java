package com.zkzong.job.fixture.repository;

import com.zkzong.job.fixture.entity.Foo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class FooRepository {

    private Map<Long, Foo> data = new ConcurrentHashMap<Long, Foo>(300, 1);

    public FooRepository() {
        init();
    }

    private void init() {
        addData(0L, 100L, "Beijing");
        addData(100L, 200L, "Shanghai");
        addData(200L, 300L, "Guangzhou");
    }

    private void addData(long idFrom, long idTo, String location) {
        for (long i = idFrom; i < idTo; i++) {
             data.put(i, new Foo(i, location, Foo.Status.TODO));
        }
    }

    public List<Foo> findTodoData(String location, int limit) {
        List<Foo> result = new ArrayList<Foo>(limit);
        int count = 0;
        for (Map.Entry<Long, Foo> each : data.entrySet()) {
            Foo foo = each.getValue();
            if (foo.getLocation().equals(location) && foo.getStatus() == Foo.Status.TODO) {
                result.add(foo);
                count++;
                if (count == limit) {
                    break;
                }
            }
        }
        return result;
    }

    public void setCompleted(long id) {
        data.get(id).setStatus(Foo.Status.COMPLETED);
    }

}
