package cn.mldn.mldnspring.springmvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // 所有需要被Spring管理的程序类一定要进行配置
public class ErrorAction { // 定义了一个自己的处理程序类
	@RequestMapping("/pages/error")
	public String error() {
		return "error";
	}  
}
