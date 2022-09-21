package org.example.springboot.jdbc;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StopWatch;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JdbcApplicationTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testDBTime() {

        StopWatch stopwatch = new StopWatch("执行sql时间消耗");

        /**
         * auto_increment key任务
         */
        final String insertSql = "INSERT INTO user_key_auto(user_id,user_name,sex,address,city,email,state) VALUES(?,?,?,?,?,?,?)";
        //List<UserKeyAuto> insertData = autoKeyTableService.getInsertData();
        stopwatch.start("自动生成key表任务开始");
        long start1 = System.currentTimeMillis();
        //if (CollectionUtil.isNotEmpty(insertData)) {
        //    boolean insertResult = jdbcTemplateService.insert(insertSql, insertData, false);
        //    System.out.println(insertResult);
        //}
        for (int i = 0; i < 100000; i++) {
            jdbcTemplate.update(insertSql, i + 1, i + 1, 1, "beijing", "beijing", "zong@163.com", 10);
        }
        long end1 = System.currentTimeMillis();
        System.out.println("auto key消耗的时间:" + (end1 - start1));

        stopwatch.stop();


        /**
         * uudID的key
         */
        final String insertSql2 = "INSERT INTO user_uuid(id,user_id,user_name,sex,address,city,email,state) VALUES(?,?,?,?,?,?,?,?)";
        //List<UserKeyUUID> insertData2 = uuidKeyTableService.getInsertData();
        stopwatch.start("UUID的key表任务开始");
        long begin = System.currentTimeMillis();
        //if (CollectionUtil.isNotEmpty(insertData)) {
        //    boolean insertResult = jdbcTemplateService.insert(insertSql2, insertData2, true);
        //    System.out.println(insertResult);
        //}
        for (int i = 0; i < 100000; i++) {
            jdbcTemplate.update(insertSql2, IdUtil.randomUUID(), i + 1, i + 1, 1, "beijing", "beijing", "zong@163.com", 10);
        }
        long over = System.currentTimeMillis();
        System.out.println("UUID key消耗的时间:" + (over - begin));

        stopwatch.stop();


        /**
         * 随机的long值key
         */
        final String insertSql3 = "INSERT INTO user_random_key(id,user_id,user_name,sex,address,city,email,state) VALUES(?,?,?,?,?,?,?,?)";
        //List<UserKeyRandom> insertData3 = randomKeyTableService.getInsertData();
        stopwatch.start("随机的long值key表任务开始");
        Long start = System.currentTimeMillis();
        //if (CollectionUtil.isNotEmpty(insertData)) {
        //    boolean insertResult = jdbcTemplateService.insert(insertSql3, insertData3, true);
        //    System.out.println(insertResult);
        //}
        for (int i = 0; i < 100000; i++) {
            jdbcTemplate.update(insertSql3, RandomUtil.randomInt(), i + 1, i + 1, 1, "beijing", "beijing", "zong@163.com", 10);
        }
        Long end = System.currentTimeMillis();
        System.out.println("随机key任务消耗时间:" + (end - start));
        stopwatch.stop();


        String result = stopwatch.prettyPrint();
        System.out.println(result);
    }

    private AtomicInteger ai = new AtomicInteger();

    /**
     * 使用线程池插入
     */
    @Test
    public void testDBTimePool() {

        StopWatch stopwatch = new StopWatch("执行sql时间消耗");

        /**
         * auto_increment key任务
         */
        final String insertSql = "INSERT INTO user_key_auto(user_id,user_name,sex,address,city,email,state) VALUES(?,?,?,?,?,?,?)";
        stopwatch.start("自动生成key表任务开始");
        long start1 = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        for (int i = 0; i < 1000000; i++) {
            executorService.submit(
                    new Runnable() {
                        @Override
                        public void run() {
                            int i = ai.getAndIncrement();
                            if (i >= 999999) {
                                executorService.shutdown();
                            }
                            jdbcTemplate.update(insertSql, i, i, 1, "beijing", "beijing", "zong@163.com", 10);
                        }
                    }
            );
        }

        while (true) {
            if (executorService.isTerminated()) {
                break;
            }
        }

        long end1 = System.currentTimeMillis();
        System.out.println("auto key消耗的时间:" + (end1 - start1));

        stopwatch.stop();

        String result = stopwatch.prettyPrint();
        System.out.println(result);

    }
}
