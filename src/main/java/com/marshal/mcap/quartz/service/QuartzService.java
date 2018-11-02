package com.marshal.mcap.quartz.service;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/11/1
 * Time: 20:34
 * Description:
 */
public class QuartzService {

    @Autowired
    Scheduler scheduler;

//    List<TriggerDto> getTriggers(IRequest request, TriggerDto example, int page, int pagesize);
//
//    /**
//     * 查询Cron触发器列表.
//     */
//    CronTriggerDto getCronTrigger(String triggerName, String triggerGroup) throws SchedulerException;
//
//    /**
//     * 查询Simple触发器列表.
//     */
//    SimpleTriggerDto getSimpleTrigger(String triggerName, String triggerGroup) throws SchedulerException;
//
//    /**
//     * 查询job列表.
//     */
//    List<JobDetailDto> getJobDetails(IRequest request, JobDetailDto example, int page, int pagesize);
//
//    Map<String, Object> schedulerInformation() throws SchedulerException;
//
//    List<SchedulerDto> selectSchedulers(SchedulerDto schedulerDto, int page, int pagesize);
//
//    /**
//     * 新建一个JOB.
//     * @throws ClassNotFoundException
//     *             ClassNotFoundException
//     */
//    void createJob(JobCreateDto jobCreateDto) throws ClassNotFoundException, SchedulerException, JobException;
//
//    /**
//     * 删除job.
//     * @throws SchedulerException
//     *             Base class for exceptions thrown by the Quartz Scheduler.
//     */
//    void deleteJob(String jobName, String jobGroup) throws SchedulerException;
//
//    /**
//     * 启动当前的Scheduler.
//     * @deprecated
//     */
//    Map<String, Object> start() throws SchedulerException;
//
//    /**
//     * standby当前的Scheduler.
//     *
//     */
//    Map<String, Object> standby() throws SchedulerException;
//
//    /**
//     * 暂停所有job.
//     */
//    Map<String, Object> pauseAll() throws SchedulerException;
//
//    /**
//     * 继续所有job.
//     */
//    Map<String, Object> resumeAll() throws SchedulerException;
//
//    void pauseJobs(List<JobDetailDto> list) throws SchedulerException;
//
//    /**
//     * 继续执行job.
//     */
//    void resumeJobs(List<JobDetailDto> list) throws SchedulerException;
//
//    /**
//     * 删除job.
//     */
//    void deleteJobs(List<JobDetailDto> list) throws SchedulerException;
//
//    /**
//     * 暂停触发器.
//     */
//    void pauseTriggers(List<TriggerDto> list) throws SchedulerException;
//
//    /**
//     * 继续执行触发器.
//     */
//    void resumeTriggers(List<TriggerDto> list) throws SchedulerException;
//
//    /**
//     * 查询job列表.
//     */
//    List<JobInfoDetailDto> getJobInfoDetails(IRequest request, JobDetailDto example, int page, int pagesize);
//
//}


 }
