package com.zc.scheduling;

import org.apache.commons.pool2.impl.BaseObjectPoolConfig;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 配置说明:https://www.cnblogs.com/linjiqin/archive/2013/07/08/3178452.html
 * Seconds Minutes Hours DayofMonth Month DayofWeek Year或
 * Seconds Minutes Hours DayofMonth Month DayofWeek
 *
 0 0 10,14,16 * * ? 每天上午10点，下午2点，4点
 0 0/30 9-17 * * ? 朝九晚五工作时间内每半小时
 0 0 12 ? * WED 表示每个星期三中午12点
 "0 0 12 * * ?" 每天中午12点触发
 "0 15 10 ? * *" 每天上午10:15触发
 "0 15 10 * * ?" 每天上午10:15触发
 "0 15 10 * * ? *" 每天上午10:15触发
 "0 15 10 * * ? 2005" 2005年的每天上午10:15触发
 "0 * 14 * * ?" 在每天下午2点到下午2:59期间的每1分钟触发
 "0 0/5 14 * * ?" 在每天下午2点到下午2:55期间的每5分钟触发
 "0 0/5 14,18 * * ?" 在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
 "0 0-5 14 * * ?" 在每天下午2点到下午2:05期间的每1分钟触发
 "0 10,44 14 ? 3 WED" 每年三月的星期三的下午2:10和2:44触发
 "0 15 10 ? * MON-FRI" 周一至周五的上午10:15触发
 "0 15 10 15 * ?" 每月15日上午10:15触发
 "0 15 10 L * ?" 每月最后一日的上午10:15触发
 "0 15 10 ? * 6L" 每月的最后一个星期五上午10:15触发
 "0 15 10 ? * 6L 2002-2005" 2002年至2005年的每月的最后一个星期五上午10:15触发
 "0 15 10 ? * 6#3" 每月的第三个星期五上午10:15触发
 */
@Component
public class QuartzService {

    static Jedis JEDIS;
    static {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxWaitMillis(100);
        JedisPool jedisPool = new JedisPool(poolConfig, "127.0.0.1", 6379);
        JEDIS = jedisPool.getResource();
    }

    private static final String LOCK = "task-job-lock";

    private static final String KEY = "tasklock";

    /**
     * 通过redis分布式锁实现定时任务只执行一次
     * @throws InterruptedException
     */
//    @Scheduled(cron = "0/3 * * * * ?") //每隔3秒触发一次
    public void task01() throws InterruptedException{
        System.out.println("=====进入task01");
        if (JEDIS.get(KEY) == null) {

            System.out.println("=====task01抢到锁");
            JEDIS.set(KEY,LOCK);

            System.out.println("nowTime=" + new Date() + "--task01执行任务");

            System.out.println("=====task01释放锁");
            JEDIS.del(KEY);
        }
    }

//    @Scheduled(cron = "0/3 * * * * ?") //每隔3秒触发一次
    public void task02() throws InterruptedException{
        Thread.sleep(100);
        System.out.println("=====进入task02");
        if (JEDIS.get(KEY) == null) {

            System.out.println("=====task02抢到锁");
            JEDIS.set(KEY, LOCK);

            System.out.println("nowTime=" + new Date() + "--task02执行任务");

            System.out.println("=====task02释放锁");
            JEDIS.del(KEY);
        }
    }

    @Scheduled(cron = "0/3 * * * * ?") //每隔3秒触发一次
    public void callTask() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                try {
                    task01();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    public static void main(String[] args) {
        JEDIS.del(KEY);
        System.out.println(JEDIS.get(KEY));
    }
}