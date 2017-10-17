package cn.mldn.mldnspring.aop.service.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceAdvice { // 随意定义的一个类的名称
	@Around("execution(public * cn.mldn..service..*.*(..))")
	public Object handleRound(ProceedingJoinPoint point) throws Throwable {	// 定义一个环绕处理通知
		System.err.print("【A、环绕通知 - handleRound】业务方法调用前。参数：" + Arrays.toString(point.getArgs())) ;
		Object returnValue = null ;	// 表示的是进行方法返回值的接收处理
		try {
			returnValue = point.proceed(new Object[] {"假的参数我乐意传"}) ;	// 修改了真实的传递参数
		} catch (Exception e) {	// 异常向上继续抛出
			System.err.print("【C、环绕通知 - handleRound】产生异常。异常：" + e) ;
			throw e ;
		}
		System.err.print("【B、环绕通知 - handleRound】业务方法执行完毕。返回值：" + returnValue) ;
		return returnValue ;
	}
	@Before(value="execution(public * cn.mldn..service..*.*(..)) and args(msg)",argNames="msg")
	public void handleBefore(String tempMsg) { // 处理前置通知
		LoggerFactory.getLogger(ServiceAdvice.class)
				.info("【### 1、ServiceAdvice-handleBefore ###】进行业务的前置处理操作。接收参数内容为：" + tempMsg); // 进行日志输出
	}
	@AfterThrowing(value="execution(public * cn.mldn..service..*.*(..))",throwing="e",argNames="e")
	public void handleThrow(Exception exp) { // 异常处理通知
		LoggerFactory.getLogger(ServiceAdvice.class)
				.info("【### 4、ServiceAdvice-handleThrow ###】方法执行产生了异常：" + exp);
	}
	@AfterReturning(value="execution(public * cn.mldn..service..*.*(..))",argNames="r",returning="r")
	public void handleReturn(String retMsg) { // 处理返回通知
		LoggerFactory.getLogger(ServiceAdvice.class)
				.info("【### 3、ServiceAdvice-handleReturn ###】业务方法执行完毕：" + retMsg); // 进行日志输出
	}
	@After(value="execution(public * cn.mldn..service..*.*(..))")
	public void handleAfter() { // 处理后置操作通知
		LoggerFactory.getLogger(ServiceAdvice.class).info("【### 2、ServiceAdvice-handleAfter ###】进行业务的后置处理操作。"); // 进行日志输出
	}
}
