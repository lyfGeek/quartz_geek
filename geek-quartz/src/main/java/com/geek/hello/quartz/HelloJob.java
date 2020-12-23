package com.geek.hello.quartz;

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

        System.out.println("helloWorld,!");

        JobKey jobKey = jobExecutionContext.getJobDetail().getKey();
        System.out.println("job name: " + jobKey.getName() + ", job group: " + jobKey.getGroup());
        // job name: myJob, job group: group1
        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        System.out.println("trigger name: " + triggerKey.getName() + ", trigger group: " + triggerKey.getGroup());
        // trigger name: myTrigger, trigger group: group1

        // 获取自定义数据。
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        JobDataMap triggerDataMap = jobExecutionContext.getTrigger().getJobDataMap();
//        String jobMsg = jobDataMap.getString("message");
//        System.out.println("jobMsg = " + jobMsg);
        // jobMsg = Hello, myJob1
        System.out.println("message = " + message);

        float jobFloatValue = jobDataMap.getFloat("floatJobValue");
        System.out.println("jobFloatValue = " + jobFloatValue);
        // jobFloatValue = 3.14
        String triggerMsg = triggerDataMap.getString("message");
        System.out.println("triggerMsg = " + triggerMsg);
        // triggerMsg = Hello, myTrigger1

        System.out.println("floatJobValue = " + floatJobValue);

        double triggerDoubleValue = triggerDataMap.getDouble("doubleTriggerValue");
        System.out.println("triggerDoubleValue = " + triggerDoubleValue);
        // triggerDoubleValue = 2.0

        System.out.println("doubleTriggerValue = " + doubleTriggerValue);

        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        System.out.println("mergedJobDataMap = " + mergedJobDataMap);
        // org.quartz.JobDataMap@93516269
    }

}
