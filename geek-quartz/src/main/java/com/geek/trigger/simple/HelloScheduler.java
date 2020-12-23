package com.geek.trigger.simple;

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

        // 获取距离当前时间 4 秒后的时间。
        date.setTime(date.getTime() + 4000);

        // trigger 对象指定频率。
        // 距离当前时间 4 秒后执行且只执行一次。
        SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger", "group1")
                .startAt(date)
                .build();

        // 创建 scheduler 实例。工厂模式。
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        // 以 trigger 指定的频率执行 JobDetail 任务。
        scheduler.scheduleJob(jobDetail, trigger);
    }

}
