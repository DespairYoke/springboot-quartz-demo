package com.zwd.schedule.demo.jobs;

import org.quartz.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author zwd
 * @date 2018/7/24 17:10
 * @Email stephen.zwd@gmail.com
 */
public class DumbJob implements Job{
    String jobSays;
    float myFloatValue;
    ArrayList state;

    public DumbJob() {
    }

    public void execute(JobExecutionContext context)
            throws JobExecutionException
    {
        JobKey key = context.getJobDetail().getKey();
//
//        JobDataMap dataMap = context.getMergedJobDataMap();  // Note the difference from the previous example
//
//        state.add(new Date());

        System.err.println("Instance " + key + " of DumbJob says: " + jobSays + ", and val is: " + myFloatValue);
    }

    public void setJobSays(String jobSays) {
        this.jobSays = jobSays;
    }

    public void setMyFloatValue(float myFloatValue) {
        this.myFloatValue = myFloatValue;
    }

    public void setState(ArrayList state) {
        state = state;
    }
}
