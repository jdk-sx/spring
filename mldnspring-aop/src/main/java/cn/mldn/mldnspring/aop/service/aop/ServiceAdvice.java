package cn.mldn.mldnspring.aop.service.aop;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceAdvice { // 随意定义的一个类的名称
	public void handleBefore(String tempMsg) { // 处理前置通知
		LoggerFactory.getLogger(ServiceAdvice.class)
				.info("【### ServiceAdvice-handleBefore ###】进行业务的前置处理操作。接收参数内容为：" + tempMsg); // 进行日志输出
	}

	public void handleAfter() { // 处理后置操作通知
		LoggerFactory.getLogger(ServiceAdvice.class).info("【### ServiceAdvice-handleAfter ###】进行业务的后置处理操作。"); // 进行日志输出
	}
}
