package cn.mldn.client.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.remote.service.IMessageService;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class) // 设置要使用的测试工具
public class TestMessageClient extends TestCase {
	@Resource
	private IMessageService messageService;

	@Test
	public void testEcho() throws Exception {
		System.err.println(this.messageService.echo("www.mldn.cn"));
	}
}
