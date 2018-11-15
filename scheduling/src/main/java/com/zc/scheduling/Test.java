package com.zc.scheduling;

import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    private static Jedis JEDIS = new Jedis("localhost",6379);;

    private static final String LOCK = "task-job-lock";

    private static final String KEY = "tasklock";

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 2; i++) {
            executorService.execute(() -> {
                try {
                    task01();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void task01() throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + "=====进入task01");
        if (JEDIS.get(KEY) == null) {

            System.out.println(Thread.currentThread().getName() + "=====task01抢到锁");
            JEDIS.set(KEY,LOCK);

            System.out.println(Thread.currentThread().getName() + "nowTime=" + new Date() + "--task01执行任务");

            System.out.println(Thread.currentThread().getName() + "=====task01释放锁");
            JEDIS.del(KEY);
        }
    }
}
