package cn.mldn.mldnspring.resource;

import org.junit.runner.RunWith;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = { "classpath:spring/spring-context.xml" }) // 进行资源文件定位
@RunWith(SpringJUnit4ClassRunner.class) // 设置要使用的测试工具
public class TestResource {
}