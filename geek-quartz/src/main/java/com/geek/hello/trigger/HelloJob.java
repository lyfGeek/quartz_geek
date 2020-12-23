package com.geek.hello.trigger;

import lombok.Data;
import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author geek
 */
@Data
public class HelloJob implements Job {

    private String message;
    private Float floatJobValue;
    private Double doubleTriggerValue;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 打印当前时间。
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Exec Time Is: " + simpleDateFormat.format(date));
        // 具体业务逻辑。
        Trigger trigger = jobExecutionContext.getTrigger();
        System.out.println("start time is: " + simpleDateFormat.format(trigger.getStartTime()));
        System.out.println("end time is: " + simpleDateFormat.format(trigger.getEndTime()));
        JobKey jobKey = trigger.getJobKey();
        System.out.println("jobKey = " + jobKey);
        System.out.println(jobKey.getName());
        System.out.println(jobKey.getGroup());
    }

}
