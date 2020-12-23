package com.geek.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

/**
 * @author geek
 */
public class CancelTest {

    public static void main(String[] args) {
        // 创建 Timer 实例。
        Timer timer = new Timer();
        // 创建 Timer 实例。
        MyTimerTask task1 = new MyTimerTask("task1");
        MyTimerTask task2 = new MyTimerTask("task2");
        // 获取当前时间。并打印。
        Date startTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("start time is: " + simpleDateFormat.format(startTime));
        // task 1 首次执行是距离现在时间 3s 后执行，之后每隔 2s 执行一次。
        // task 2 首次执行是距离现在时间 1s 后执行，之后每隔 2s 执行一次。
        timer.schedule(task1, 3000, 2000);
        timer.schedule(task2, 1000, 2000);
        System.out.println("current canceled task number is: " + timer.purge());
        // 休眠 5 秒。
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 获取当前时间并打印。
        Date cancelTime = new Date();
        System.out.println("cancel time is: " + simpleDateFormat.format(cancelTime));

//        timer.cancel();
        // 取消任务 2。
        task2.cancel();
        System.out.println("current canceled task number is: " + timer.purge());
    }

}
