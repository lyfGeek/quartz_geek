package com.geek.hello.trigger;

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

        // 获取距离当前时间 3 秒后的时间。
        date.setTime(date.getTime() + 3000);

        // 获取距离当前时间 6 秒后的时间。
        Date endDate = new Date();
        endDate.setTime(date.getTime() + 6000);

        // trigger 对象指定频率。
        // 创建 Trigger 实例。定义该 Job 立即执行，并且每隔 2s 重复执行一次，直到永远。
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("myTrigger", "group1")
//                .startNow()// 立刻执行。
                .startAt(date)// 自定义时间执行。（3 秒之后）。
                .endAt(endDate)// 自定义结束时间。（6 秒之后）。
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())// 设置频率。
                .build();

        // 创建 scheduler 实例。工厂模式。
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();

        // 以 trigger 指定的频率执行 JobDetail 任务。
        scheduler.scheduleJob(jobDetail, trigger);
    }

}
