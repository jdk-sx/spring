package cn.mldn.mldnspring.di.vo;

import java.beans.ConstructorProperties;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Dept implements Serializable {
	private Long deptno ;
	private String dname ;
	private Boolean enable ;
	@ConstructorProperties(value= {"paramDeptno","paramDname","paramEnable"})
	public Dept(Long deptno,String dname,Boolean enable) {
		this.deptno = deptno ;
		this.dname = dname ;
		this.enable = enable ;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", enable=" + enable + "]";
	}
}
