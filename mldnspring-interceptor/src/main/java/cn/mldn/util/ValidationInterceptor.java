package cn.mldn.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
// 由于所有的抽象方法都使用了default关键字，那么此时不会再默认实现若干个抽象方法
public class ValidationInterceptor implements HandlerInterceptor {
	private Logger logger = LoggerFactory.getLogger(ValidationInterceptor.class) ; 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		this.logger.info("@@@1、【****** preHandle ******】" + handler.getClass());
		return true ;	// 返回true表示放行，而如果返回了false表示不执行后续的Action或拦截器
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		this.logger.info("@@@2、【****** postHandle ******】" + handler.getClass());
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		this.logger.info("@@@3、【****** afterCompletion ******】" + handler.getClass());
	} 
}
