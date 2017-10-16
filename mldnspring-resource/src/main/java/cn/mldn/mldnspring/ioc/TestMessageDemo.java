package cn.mldn.mldnspring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.mldnspring.ioc.service.IMessage;

public class TestMessageDemo {
	public static void main(String[] args) {
		// 启动Spring上下文，在以后的实际开发过程之中，这一启动过程会由WEB容器负责
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-ioc.xml") ;
		IMessage message = ctx.getBean("messageImpl",IMessage.class) ;	// 获取实例化对象
		System.out.println(message.echo("www.mldn.cn")); 
	}
}
