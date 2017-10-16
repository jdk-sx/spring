package cn.mldn.mldnspring.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.mldn.mldnspring.context.service.IDeptService;
import cn.mldn.mldnspring.context.vo.Dept;

public class TestDeptService {
	public static void main(String[] args) {
		// 启动Spring上下文，在以后的实际开发过程之中，这一启动过程会由WEB容器负责
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring-dao.xml",
				"spring/spring-service.xml"); // 加载所有的配置文件
		IDeptService deptService = ctx.getBean("deptService", IDeptService.class);
		Dept dept = new Dept() ;	// 创建VO对象
		dept.setDeptno(10L);
		dept.setDname("财务部");
		System.out.println(deptService.add(dept));
	}
}
