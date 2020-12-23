package com.geek.trigger.cron;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author geek
 */
public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException {

        // 打印当前时间。
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time Is: " + simpleDateFormat.format(date));

        // 重写 org.quartz.Job 中 run(); 方法
        // 编写自己的逻辑。
        // 创建一个 JobDetail 实例，将该实例与 HelloJob 绑定。
        JobDetail jobDetail = JobBuilder
                .newJob(HelloJob.class)
                .withIdentity("myJob", "group1")// 标识。
                .build();

        // trigger 对象指定频率。
        CronTrigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger", "group1")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("* * * * * ? *")// 每秒。
//                        CronScheduleBuilder.cronSchedule("0 58 15 ? * * 2020")

                        // 2020 年每天 10 点 13。
//                        0 13 10 ? * * 2020
                        // 每天 14 点到 14 点 59 分 55 秒，以及 18 点整到 18 点 59 分 55 秒，每 5 秒触发一次。
//                        0/5 * 14,18 * * ?
                        // 每月周一至周五的 10 点 13 分。
//                        * 13 10 * 0-4 ?
                        // 每月最后一天的 10 点 13。

                        // 每月第三个周五的 10 点 13 分。
                )
                .build();

        // 创建 scheduler 实例。工厂模式。
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        // 以 trigger 指定的频率执行 JobDetail 任务。
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
