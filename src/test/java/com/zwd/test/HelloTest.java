package com.zwd.test;

import com.zwd.schedule.demo.Main;
import com.zwd.schedule.demo.jobs.DataParseJob;
import com.zwd.schedule.demo.jobs.DumbJob;
import com.zwd.schedule.demo.jobs.HelloJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.quartz.SimpleScheduleBuilder.simpleSchedule;

/**
 * @author zwd
 * @date 2018/7/23 20:12
 * @Email stephen.zwd@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Main.class})
public class HelloTest {

    @Autowired
    private Scheduler scheduler;
    @Test
    public void testHello() throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .startNow()
                .build();
        scheduler.scheduleJob(jobDetail,trigger);
    }

    /**5秒后say hello*/
    @Test
    public void testHello2() throws SchedulerException, InterruptedException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","group1")
                .startAt(new Date(new Date().getTime()+5000))
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(20)
                        .repeatForever())
                .build();
        scheduler.scheduleJob(jobDetail,trigger);
        Thread.sleep(50000);
    }

    /**参数传递*/
    @Test
    public void testHello3() throws SchedulerException, InterruptedException {
        JobDetail jobDetail = JobBuilder.newJob(DataParseJob.class)
                .usingJobData("id",5)
                .usingJobData("name","zwd")
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(20)
                        .repeatForever())
                .build();
        scheduler.scheduleJob(jobDetail,trigger);
        Thread.sleep(50000);
    }

    /**参数映射*/
    @Test
    public void testHello4() throws SchedulerException, InterruptedException {
        JobDetail jobDetail = JobBuilder.newJob(DumbJob.class)
                .usingJobData("jobSays", "Hello World!")
                .usingJobData("myFloatValue", 3.141f)
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(20)
                        .repeatForever())
                .build();
        scheduler.scheduleJob(jobDetail,trigger);
        Thread.sleep(50000);
    }

}
