package cn.mldn.mldnspring.springmvc.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.mldn.mldnspring.springmvc.util.action.AbstractAction;

@Controller
@RequestMapping("/pages/web/*")
public class WebObjectAction extends AbstractAction {
	
	@RequestMapping("support") 
	@ResponseBody
	public Object showObjectSupport(String msg) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest() ;
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse() ;
		HttpSession session = request.getSession() ;
		ServletContext context = request.getServletContext() ;
		 
		List<String> all = new ArrayList<String>() ; 
		all.add("*** 【REQUEST内置对象】ContextPath = " + request.getContextPath()) ;
		all.add("*** 【APPLICATION内置对象】RealPath = " + context.getRealPath("/")) ;
		all.add("*** 【RESPONSE内置对象】RealPath = " + response.getLocale()) ;
		all.add("*** 【SESSION内置对象】SessionID = " + session.getId()) ; 
		return all ;
	}
	
	@RequestMapping("show") 
	@ResponseBody
	public Object showObject(String msg, HttpServletRequest request, HttpServletResponse response) {
		List<String> all = new ArrayList<String>() ; 
		all.add("*** 【REQUEST内置对象】ContextPath = " + request.getContextPath()) ;
		all.add("*** 【APPLICATION内置对象】RealPath = " + request.getServletContext().getRealPath("/")) ;
		all.add("*** 【RESPONSE内置对象】RealPath = " + response.getLocale()) ;
		all.add("*** 【SESSION内置对象】SessionID = " + request.getSession().getId()) ;
		return all ;
	}

}
