package cn.mldn.mldnspring.di;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import cn.mldn.mldnspring.di.vo.Dept;

public class TestDeptDemo {
	public static void main(String[] args) {
		// 启动Spring上下文，在以后的实际开发过程之中，这一启动过程会由WEB容器负责
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-di.xml") ;
		Dept dept = ctx.getBean("deptObj",Dept.class) ;
		System.out.println(dept);
		System.out.println(dept.getInfos());
		System.out.println(dept.getEmps());
		System.out.println(dept.getInfos().getClass().getName());
	}
}
