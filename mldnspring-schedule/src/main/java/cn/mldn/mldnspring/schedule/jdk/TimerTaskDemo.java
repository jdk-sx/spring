package cn.mldn.mldnspring.schedule.jdk;

import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

class MyTask extends TimerTask { // 首先定义一个要执行的定时调度任务功能
	@Override
	public void run() { // 表示要执行的任务主体代码
		System.out.println("【当前的日期时间】" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new java.util.Date()));
	}
}

public class TimerTaskDemo {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new MyTask(), 0, 1000); // 立即启动，没有延迟，并且每秒执行一次
	}
}
