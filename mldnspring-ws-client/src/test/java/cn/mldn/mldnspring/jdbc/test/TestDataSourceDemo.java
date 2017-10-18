package cn.mldn.mldnspring.jdbc.test;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class) // 设置要使用的测试工具
public class TestDataSourceDemo extends TestCase {
	@Resource
	private DataSource dataSource ;
	@Test
	public void testConnection() throws Exception {
		System.out.println(this.dataSource.getConnection());
	} 
}
