package com.zwd.test;

import com.zwd.schedule.demo.jobs.HelloJob;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * @author zwd
 * @date 2018/7/24 12:40
 * @Email stephen.zwd@gmail.com
 */
public class SImpleTest {


    @Test
    public void hello() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        // define the job and tie it to our HelloJob class
        JobDetail job = newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .build();

        // Trigger the job to run now, and then repeat every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(40)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);
        scheduler.shutdown();
    }
}
