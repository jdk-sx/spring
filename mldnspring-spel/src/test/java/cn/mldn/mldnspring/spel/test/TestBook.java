package cn.mldn.mldnspring.spel.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.mldnspring.spel.vo.Book;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" }) // 进行资源文件定位
@RunWith(SpringJUnit4ClassRunner.class) // 设置要使用的测试工具
public class TestBook {
	@Resource
	private Book book ;
	@Test  
	public void testPrint() {
		System.out.println(this.book);
	}
}
