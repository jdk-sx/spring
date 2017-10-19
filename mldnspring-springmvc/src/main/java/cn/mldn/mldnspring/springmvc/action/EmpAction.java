package cn.mldn.mldnspring.springmvc.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mldn.mldnspring.springmvc.util.action.AbstractAction;
import cn.mldn.mldnspring.springmvc.vo.Dept;
import cn.mldn.mldnspring.springmvc.vo.Emp;

@Controller
@RequestMapping("/pages/emp/*")
public class EmpAction extends AbstractAction {
	@RequestMapping("emp_list")
	@ResponseBody 	// 使用此注解就表示返回的对象自动变为JSON对象
	public Object list() {
		List<Emp> all = new ArrayList<Emp>() ;
		for (int x = 0 ; x < 10 ; x ++) {
			Emp vo = new Emp() ;
			vo.setEmpno(7369L + x);
			vo.setEname("约翰 - " + x);
			Dept dept = new Dept() ;
			dept.setDeptno(10L + x);
			dept.setDname("服务部 - " + x);
			vo.setDept(dept);
			all.add(vo) ;
		}
		return all ;
	}
	
	@RequestMapping("emp_map")
	@ResponseBody 	// 使用此注解就表示返回的对象自动变为JSON对象
	public Object map() {
		Map<String,Emp> all = new HashMap<String,Emp>() ;
		for (int x = 0 ; x < 10 ; x ++) {
			Emp vo = new Emp() ;
			vo.setEmpno(7369L + x);
			vo.setEname("约翰 - " + x);
			Dept dept = new Dept() ;
			dept.setDeptno(10L + x);
			dept.setDname("服务部 - " + x);
			vo.setDept(dept);
			all.put("雇员信息 - " + x, vo) ;
		}
		return all ;
	}
	
	
	@RequestMapping("emp_add")
	@ResponseBody 	// 使用此注解就表示返回的对象自动变为JSON对象
	public Object add(Emp emp) {	// 自动进行Emp对象的接收处理操作
		return emp ; 
	}
 
}
