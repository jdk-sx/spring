package cn.mldn.mldnspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.mldn.mldnspring.context.dao.IDeptDAO;
import cn.mldn.mldnspring.context.dao.impl.DeptDAOImpl;

@Configuration	// 表示当前的类是一个专门用于配置的实现类
public class MLDNDAOConfig {
	// <bean id="deptDAO" class="cn.mldn.mldnspring.context.dao.impl.DeptDAOImpl" />
	@Bean(name="deptDAOImpl") 
	public IDeptDAO getDeptDAOInstance() {	// 方法名称可以随便你去编写
		return new DeptDAOImpl() ;	// 返回一个实例化对象
	}
}
