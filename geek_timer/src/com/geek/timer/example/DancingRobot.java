package com.geek.timer.example;

import java.text.SimpleDateFormat;
import java.util.TimerTask;

/**
 * @author geek
 */
public class DancingRobot extends TimerTask {

    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        // 获取最近一次执行时间并将其格式化。
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Scheduled exec time is: " + simpleDateFormat.format(scheduledExecutionTime()));
        System.out.println("Dancing...");
    }

}
