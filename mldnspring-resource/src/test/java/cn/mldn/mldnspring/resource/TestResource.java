package cn.mldn.mldnspring.resource;

import java.util.Scanner;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.mldnspring.resource.util.DefaultResourceBean;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" }) // 进行资源文件定位
@RunWith(SpringJUnit4ClassRunner.class) // 设置要使用的测试工具
public class TestResource {
	@Resource
	private DefaultResourceBean resourceBean ;
	@Test
	public void testResource() throws Exception { 
		for (int x = 0 ; x < this.resourceBean.getResources().length ; x ++) {
			Scanner scan = new Scanner(this.resourceBean.getResources()[x].getInputStream()) ;
			scan.useDelimiter("\n") ; 
			while (scan.hasNext()) {
				System.out.print(scan.next()); 
			}
			scan.close(); 
			System.out.println("******************************************");
		}
	}
}