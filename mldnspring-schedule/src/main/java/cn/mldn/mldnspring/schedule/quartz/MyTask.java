package cn.mldn.mldnspring.schedule.quartz;

import java.text.SimpleDateFormat;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyTask extends QuartzJobBean { // 此时就定义好了一个专门负责任务处理的程序类

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		System.out.println("【当前的日期时间】" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date()));
	}

}
