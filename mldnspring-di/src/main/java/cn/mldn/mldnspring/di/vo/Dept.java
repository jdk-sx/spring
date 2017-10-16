package cn.mldn.mldnspring.di.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("serial")
public class Dept implements Serializable {
	private Long deptno ;
	private String dname ;
	private Boolean enable ;
	private Map<Integer,String> infos ;
	private Map<String,Emp> emps ;
	public void setEmps(Map<String, Emp> emps) {
		this.emps = emps;
	}
	public void setInfos(Map<Integer, String> infos) {
		this.infos = infos;
	}
	public Map<String, Emp> getEmps() {
		return emps;
	}
	public Map<Integer, String> getInfos() {
		return infos;
	}
	public Long getDeptno() {
		return deptno;
	}
	public void setDeptno(Long deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", enable=" + enable + "]";
	}
}
