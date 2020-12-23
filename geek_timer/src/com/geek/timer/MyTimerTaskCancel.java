package com.geek.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * @author geek
 */
public class MyTimerTaskCancel extends TimerTask {

    private String name;
    private Integer iCount = 0;

    public MyTimerTaskCancel(String name) {
        this.name = name;
    }

    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        if (iCount < 3) {
            // 以 yyyy-MM-dd HH:mm:ss 的格式打印当前执行时间。
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("Current exec time is: " + simpleDateFormat.format(calendar.getTime()));

            // 打印当前 name 的内容。
            System.out.println("Current exec name is: " + name);
            ++iCount;
        } else {
            cancel();
            System.out.println("Task cancel...");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
