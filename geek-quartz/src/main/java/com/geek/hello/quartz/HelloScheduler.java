package com.geek.hello.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author geek
 */
public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException {

        // 重写 org.quartz.Job 中 run(); 方法
        // 编写自己的逻辑。
        // 创建一个 JobDetail 实例，将该实例与 HelloJob 绑定。
        JobDetail jobDetail = JobBuilder
                .newJob(HelloJob.class)
                .withIdentity("myJob", "group1")// 标识。
                // 自定义参数。
                .usingJobData("message", "Hello, myJob1")
                .usingJobData("floatJobValue", 3.14F)
                .build();

//        System.out.println(jobDetail.getKey().getName());// myJob / 6da64b5bd2ee-3e0fb328-7c23-4e56-b4c8-15f00186fec9
//        System.out.println(jobDetail.getKey().getGroup());// group1 / DEFAULT
//        System.out.println(jobDetail.getKey().getClass());// class org.quartz.JobKey

        // trigger 对象指定频率。
        // 创建 Trigger 实例。定义该 Job 立即执行，并且每隔 2s 重复执行一次，直到永远。
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger", "group1")
                .usingJobData("message", "Hello, myTrigger1")
                .usingJobData("doubleTriggerValue", 2.0D)
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())// 设置频率。
                .build();

        // 创建 scheduler 实例。工厂模式。
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        // 打印当前时间。
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time Is: " + simpleDateFormat.format(date));

        // 以 trigger 指定的频率执行 JobDetail 任务。
        scheduler.scheduleJob(jobDetail, trigger);
    }

}
