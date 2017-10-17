package cn.mldn.mldnspring.schedule.task;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
@Component	// 必须明确的告诉Spring，现在的MyTask是一个Spring容器管理的bean
public class MyTaskFirst {
	@Scheduled(cron="* * * * * ?") 
	public void runTask() throws InterruptedException {	// 自己随意定义了一个方法名称
		TimeUnit.SECONDS.sleep(5); // 每一次休眠5秒
		System.out.println("@@@@@@【第一个任务 - 当前的日期时间】" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date()));
	}

}