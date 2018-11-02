package com.marshal.mcap.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String dataMap = jobExecutionContext.getJobDetail().getJobDataMap().getString("test1");
        Float testD = jobExecutionContext.getJobDetail().getJobDataMap().getFloat("testD");
        System.out.println("------------------------");
        System.out.println("Hello Job Execute");
        System.out.println("------------------------");
    }
}
