package com.geek.scheduler;

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

        // 启动。
        scheduler.start();

//        // StdSchedulerFactory。
//        // 使用一组参数（java.util.Properties）来创建和初始化 Quartz 调度器。
//        // 配置参数一般存储在 quartz.properties 中。
//        // 调用 stdSchedulerFactory.getScheduler(); 就能创建和初始化调度器对象。
//        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
//        Scheduler scheduler = stdSchedulerFactory.getScheduler();

        // 以 trigger 指定的频率执行 JobDetail 任务。
        // 返回 Date。
        Date job = scheduler.scheduleJob(jobDetail, trigger);
        System.out.println(simpleDateFormat.format(job));

        // schedule 执行 2 秒后挂起。
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduler.standby();

//        scheduler.shutdown();// 不能重启了。
//        scheduler.shutdown(true);// waitForJobsToComplete。
        scheduler.shutdown(false);// waitForJobsToComplete。

        System.out.println(scheduler.isShutdown());

        // 挂起 3 秒后再次启动。
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduler.start();
    }

}
