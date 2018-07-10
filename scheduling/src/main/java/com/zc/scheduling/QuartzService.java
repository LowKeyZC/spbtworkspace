package com.zc.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class QuartzService {

    @Scheduled(cron = "* * * * * ?")
    public void task01() throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + "===== task01");
        TimeUnit.SECONDS.sleep(2);
    }
}