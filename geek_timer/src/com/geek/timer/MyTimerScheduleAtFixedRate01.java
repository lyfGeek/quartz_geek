package com.geek.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * @author geek
 */
public class MyTimerScheduleAtFixedRate01 {

    public static void main(String[] args) {
        // 创建一个 Timer 实例。
        Timer timer = new Timer();
        // 创建一个 MyTimerTask 实例。
        MyTimerTask myTimerTask = new MyTimerTask("No.1");

        // 获取当前时间。并设置为当前时间 3s 后的时间。
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(calendar.getTime()));
        calendar.add(Calendar.SECOND, 3);

        myTimerTask.setName("scheduleAtFixedRate 1");
        // 通过 Timer 定时定频率调用 myTimerTask 的业务逻辑。
        // 在时间等于或超过 time 的时候执行且执行一次 task。
        timer.scheduleAtFixedRate(myTimerTask, calendar.getTime(), 2000);
    }

}
