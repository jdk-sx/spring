package cn.mldn.mldnspring.context.service.impl;

import cn.mldn.mldnspring.context.dao.IDeptDAO;
import cn.mldn.mldnspring.context.service.IDeptService;
import cn.mldn.mldnspring.context.vo.Dept; 

public class DeptServiceImpl implements IDeptService {
	private IDeptDAO deptDAO ; 	// 定义IDeptDAO接口对象
	public void setDeptDAO(IDeptDAO deptDAO) {	// 该对象要通过外部进行注入
		this.deptDAO = deptDAO;	// 数据层对象的实例化控制完全由Spring负责处理
	}
	@Override
	public boolean add(Dept dept) {
		System.out.println("******** Dept业务层调用 *********");
		return this.deptDAO.doCreate(dept); 
	}

}
