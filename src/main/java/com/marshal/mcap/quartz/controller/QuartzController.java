package com.marshal.mcap.quartz.controller;

import com.marshal.mcap.quartz.entity.JobRunningInfo;
import com.marshal.mcap.quartz.service.JobRunningInfoService;
import com.marshal.mcap.system.entity.ResponseData;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/11/1
 * Time: 20:05
 * Description:定时任务控制器
 */
@RestController
@RequestMapping("/quartz")
public class QuartzController {

    @Autowired
    Scheduler scheduler;

    @Autowired
    JobRunningInfoService jobRunningInfoService;

    @RequestMapping("/test")
    public void demo() throws SchedulerException {
        // define the job and tie it to our HelloJob class
        JobDetail job = newJob(com.marshal.mcap.quartz.job.HelloJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("test1","helloTest1")
                .usingJobData("testD",3.14F)
                .build();

        // Trigger the job to run now, and then repeat every 40 seconds
        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(10)
                        .repeatForever())
                .build();

        // Tell quartz to schedule the job using our trigger
        scheduler.scheduleJob(job, trigger);
    }

    /**
     * 获取任务执行记录
     * @param condition
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/jobRunningInfo/query")
    public ResponseData queryJobRunningInfo(@RequestBody JobRunningInfo condition,
                                            @RequestParam("pageNum") int pageNum,
                                            @RequestParam("pageSize") int pageSize){
        return new ResponseData(jobRunningInfoService.queryJobRunningInfo(condition,pageNum,pageSize));
    }
}
