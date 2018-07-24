package com.zwd.schedule.demo.jobs;

import org.quartz.*;



public class HighLevelParameterJob implements Job {

    private String Msg;

    public HighLevelParameterJob() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobKey key = jobExecutionContext.getJobDetail().getKey();

        JobDataMap dataMap = jobExecutionContext.getMergedJobDataMap();

        System.out.println("HighLevelParameterJob's Msg is : " + this.Msg);
    }

    public void setMsg(String msg) {
        Msg = msg;
    }
}
