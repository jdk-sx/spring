package cn.mldn.mldnspring.springmvc.util.action;

import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class AbstractAction {
	@InitBinder 
	public void initBinder(WebDataBinder binder) {	// 设置一个Web数据的绑定转换
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd") ;	// 定义转换处理
		// 在WEB数据绑定之中注册一个自定义的规则绑定器，该操作主要是对java.util.Date类型处理，允许为null
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
	}
}
