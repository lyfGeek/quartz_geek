package com.geek.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author geek
 */
public class DifferenceTest {

    public static void main(String[] args) {
        test2();
    }

    private static void test2() {
        // 时间格式。
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获取当前具体时间。
        Calendar calendar = Calendar.getInstance();
        System.out.println("Current time is: " + simpleDateFormat.format(calendar.getTime()));
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
        /*
        Current time is: 2020-06-02 15:56:00
        scheduledExecutionTime: 2020-06-02 15:56:00
        Task is executing...
        scheduledExecutionTime: 2020-06-02 15:56:02
        Task is executing...
        scheduledExecutionTime: 2020-06-02 15:56:04
        Task is executing...
         */

            //        timer.schedule(new TimerTask() {
            /*
            Current time is: 2020-06-02 15:57:09
            scheduledExecutionTime: 2020-06-02 15:57:09
            Task is executing...
            scheduledExecutionTime: 2020-06-02 15:57:12
            Task is executing...
            scheduledExecutionTime: 2020-06-02 15:57:15
            Task is executing...
             */
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 打印当前的计划执行时间。
                System.out.println("scheduledExecutionTime: " + simpleDateFormat.format(scheduledExecutionTime()));
                System.out.println("Task is executing...");
            }
        }, calendar.getTime(), 2000);
    }

    private static void test1() {
        // 时间格式。
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 获取当前具体时间。
        Calendar calendar = Calendar.getInstance();
        System.out.println("Current time is: " + simpleDateFormat.format(calendar.getTime()));
        // 设置成 6 秒前的时间。
        calendar.add(Calendar.SECOND, -6);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            // 以 calendar 设置的时间为准。
            //        timer.schedule(new TimerTask() {
            // 从现在时间开始算起执行。
            @Override
            public void run() {
                // 打印当前的计划执行时间。
                System.out.println("scheduledExecutionTime: " + simpleDateFormat.format(scheduledExecutionTime()));
                System.out.println("Task is executing...");
            }
        }, calendar.getTime(), 2000);
    }

}
