package com.geek.scheduler;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.DirectSchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author geek
 */
public class Test {

    public static void main(String[] args) throws SchedulerException {

        // StdSchedulerFactory。
        // 使用一组参数（java.util.Properties）来创建和初始化 Quartz 调度器。
        // 配置参数一般存储在 quartz.properties 中。
        // 调用 stdSchedulerFactory.getScheduler(); 就能创建和初始化调度器对象。
        StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = stdSchedulerFactory.getScheduler();

        //

        DirectSchedulerFactory directSchedulerFactory = DirectSchedulerFactory.getInstance();
        Scheduler scheduler1 = directSchedulerFactory.getScheduler();
    }

}
