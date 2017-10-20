package cn.mldn.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

// 由于所有的抽象方法都使用了default关键字，那么此时不会再默认实现若干个抽象方法
public class ValidationInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(ValidationInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {	// 执行向下转型前应该首先判断其是否是指定类的实例
			HandlerMethod handlerMethod = (HandlerMethod) handler ;	// 强制转换
			this.logger.info("【处理的Action对象】" + handlerMethod.getBean());
			this.logger.info("【处理的Action-Class】" + handlerMethod.getBeanType());
			this.logger.info("【Action处理方法名称】" + handlerMethod.getMethod());
			for (int x = 0 ; x < handlerMethod.getMethodParameters().length ; x ++) {
				this.logger.info("@@【Action处理方法参数 - "+x+"】" + handlerMethod.getMethodParameters()[x]);
			}
		}
		
		return true; // 返回true表示放行，而如果返回了false表示不执行后续的Action或拦截器
	}
}
