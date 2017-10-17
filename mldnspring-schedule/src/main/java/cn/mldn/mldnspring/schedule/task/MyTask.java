package cn.mldn.mldnspring.schedule.task;

import java.text.SimpleDateFormat;

public class MyTask {
	public void runTask() {	// 自己随意定义了一个方法名称
		System.out.println("【当前的日期时间】" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date()));
	}

}