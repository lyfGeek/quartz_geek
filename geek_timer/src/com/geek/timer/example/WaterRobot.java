package com.geek.timer.example;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author geek
 */
public class WaterRobot extends TimerTask {

    private Timer timer;
    // 最大容量为 5。
    private Integer bucketCapacity = 0;

    public WaterRobot(Timer timer) {
        this.timer = timer;
    }

    /**
     * The action to be performed by this timer task.
     */
    @Override
    public void run() {
        // 灌水直至桶满。
        if (bucketCapacity < 5) {
            System.out.println("add 1L water into the bucket...");
            ++bucketCapacity;
        } else {
            // 水满了就停止。
            cancel();
            System.out.println("Current water is " + bucketCapacity + " L.");
            System.out.println("The water robot has been aborted.");
            System.out.println("The number of canceled task in timer is: " + timer.purge());
            // 等待 2s 终止Timer 中所有任务。
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            timer.cancel();
        }
    }

}
