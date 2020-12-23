package com.geek.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * @author geek
 */
public class MyTimerCancel {

    public static void main(String[] args) {
        // 创建一个 timer 实例。
        Timer timer = new Timer();
        // 创建一个 MyTimerTask 实例。
        MyTimerTaskCancel myTimerTaskCancel = new MyTimerTaskCancel("No. 1");
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("cancel time is: " + simpleDateFormat.format(calendar.getTime()));

        myTimerTaskCancel.setName("schedule");
        timer.schedule(myTimerTaskCancel, 3000, 2000);
    }

}
