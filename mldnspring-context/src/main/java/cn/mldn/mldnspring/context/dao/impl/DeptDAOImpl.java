package cn.mldn.mldnspring.context.dao.impl;

import org.springframework.stereotype.Repository;

import cn.mldn.mldnspring.context.dao.IDeptDAO;
import cn.mldn.mldnspring.context.vo.Dept;
// <bean id="deptDAO" class="cn.mldn.mldnspring.context.dao.impl.DeptDAOImpl" />
// @Repository
public class DeptDAOImpl implements IDeptDAO {
	@Override
	public boolean doCreate(Dept dept) {
		System.out.println("【数据层-DeptDAOImpl】增加新部门：" + dept);
		return true;
	}

}
