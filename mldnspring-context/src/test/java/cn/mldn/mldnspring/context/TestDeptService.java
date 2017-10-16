package cn.mldn.mldnspring.context;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.mldnspring.context.service.IDeptService;
import cn.mldn.mldnspring.context.vo.Dept;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-context.xml" })	// 进行资源文件定位
@RunWith(SpringJUnit4ClassRunner.class)	// 设置要使用的测试工具
public class TestDeptService extends TestCase {
	@Autowired
	private IDeptService deptServiceNew ;	// 直接注入业务对象
	@Test
	public void testAdd() {
		Dept dept = new Dept() ;	// 创建VO对象
		dept.setDeptno(10L);
		dept.setDname("财务部");
		TestCase.assertTrue(this.deptServiceNew.add(dept));
	}
}
