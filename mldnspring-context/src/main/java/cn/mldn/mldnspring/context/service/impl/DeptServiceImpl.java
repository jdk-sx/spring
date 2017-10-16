package cn.mldn.mldnspring.context.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.mldnspring.context.dao.IDeptDAO;
import cn.mldn.mldnspring.context.service.IDeptService;
import cn.mldn.mldnspring.context.vo.Dept;
// <bean id="deptService" class="cn.mldn.mldnspring.context.service.impl.DeptServiceImpl"/>
@Service
public class DeptServiceImpl implements IDeptService {
	@Resource	// <property name="deptDAO" ref="deptDAO"/>
	private IDeptDAO deptDAO; // 定义IDeptDAO接口对象，表示该对象通过容器负责注入，会根据类型匹配
	public void setDeptDAO(IDeptDAO deptDAO) {
		this.deptDAO = deptDAO;
	}
	@Override
	public boolean add(Dept dept) {
		System.out.println("******** Dept业务层调用 *********");
		return this.deptDAO.doCreate(dept);
	}

}
