package com.example.springscheduler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class ScheduledTaskService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTaskService.class);
    @Scheduled(fixedDelay = 1000)
    public void  scheduleFixedDelayTask() throws InterruptedException{
        LOGGER.info("scheduleFixedDelayTask: begin");
        Thread.sleep(2000);
        LOGGER.info("scheduleFixedDelayTask: end");
    }

    @Scheduled(fixedRate = 1000) // фексированная скорость
    public void  scheduleFixedRateTask() throws InterruptedException{
        LOGGER.info("scheduleFixedDelayTask: begin");
        Thread.sleep(2000);
        LOGGER.info("scheduleFixedDelayTask: end");
    }

    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTaskAsync() throws InterruptedException {
        LOGGER.info("scheduleFixedDelayTask: begin3");
        Thread.sleep(2000);
        LOGGER.info("scheduleFixedDelayTask: end3");
    }

    @Async
    @Scheduled(fixedDelay = 1000, initialDelay = 10000)
    public void scheduleFixedRateWithInitialDelayTask() throws InterruptedException {
        LOGGER.info("scheduleFixedDelayTask: begin3");
        Thread.sleep(3000);
        LOGGER.info("scheduleFixedDelayTask: end3");
    }

    @Scheduled(cron = "0 * * * * ?", zone = "Europe/Moscow")
    public void scheduleCronExpressionTask() throws InterruptedException {
        LOGGER.info("scheduleFixedDelayTask: begin3");
        Thread.sleep(3000);
        LOGGER.info("scheduleFixedDelayTask: end3");
    }

    @Scheduled(fixedDelayString = "${task.fixed.delay.millis}")
    public void scheduleFixedDelayParametrizedTask() throws InterruptedException {
        LOGGER.info("scheduleFixedDelayTask: begin3");
        Thread.sleep(3000);
        LOGGER.info("scheduleFixedDelayTask: end3");
    }
}
