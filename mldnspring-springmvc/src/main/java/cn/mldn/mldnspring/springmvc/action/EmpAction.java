package cn.mldn.mldnspring.springmvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.mldnspring.springmvc.util.action.AbstractAction;
import cn.mldn.mldnspring.springmvc.vo.Emp;

@Controller
@RequestMapping("/pages/emp/*")
public class EmpAction extends AbstractAction {
	@RequestMapping("emp_add")
	public ModelAndView add(Emp emp) {	// 自动进行Emp对象的接收处理操作
		System.err.println(emp); // 直接进行对象的输出
		return null ;
	}
 
}
