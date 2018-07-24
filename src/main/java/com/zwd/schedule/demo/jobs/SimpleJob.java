package com.zwd.schedule.demo.jobs;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by liumapp on 12/28/17.
 * E-mail:liumapp.com@gmail.com
 * home-page:http://www.liumapp.com
 */
public class SimpleJob implements Job {

    public SimpleJob() {

    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Hello world , a simple job is running ! ");

        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        Object datainfo = mergedJobDataMap.get("datainfo");
        System.out.println(mergedJobDataMap);

    }

}
