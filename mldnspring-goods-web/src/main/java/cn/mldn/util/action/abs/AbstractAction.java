package cn.mldn.util.action.abs;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public abstract class AbstractAction {
	@Resource
	protected MessageSource messageSource ;
	/**
	 * 可以获得Request对象
	 * @return 方便获得
	 */
	public HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest() ;
	} 
	/**
	 * 该方法的主要功能是根据指定的key获得资源文件中对应的内容
	 * @param key 要执行的跳转路径key
	 * @return 返回路径
	 */
	public String getPage(String key) {
		try {
			return this.messageSource.getMessage(key, null, null) ;
		} catch (Exception e) {
			this.getRequest().setAttribute("errors", "NoPath"); 
			return this.messageSource.getMessage("error.page", null,null) ;
		}
	}
}
