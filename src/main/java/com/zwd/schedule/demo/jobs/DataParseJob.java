package com.zwd.schedule.demo.jobs;

import org.quartz.*;


public class DataParseJob implements Job {

    public DataParseJob() {

    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobKey key = context.getJobDetail().getKey();

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String name = dataMap.getString("name");
        int id = dataMap.getIntValue("id");

        System.err.println("Instance " + key + "id: " + id + ", and name is: " + name);
    }
}
