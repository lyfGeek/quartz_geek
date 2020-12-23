package com.geek.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * @author geek
 */
public class MyTimer03 {

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

        // 通过 Timer 定时定频率调用 myTimerTask 的业务逻辑。
        // 等待 delay 毫秒后执行且执行一次 task。
        myTimerTask.setName("schedule 3");
        timer.schedule(myTimerTask, 1000);
    }

}
