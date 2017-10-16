package cn.mldn.mldnspring.di.vo;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Dept implements Serializable {
	private Long deptno ;
	private String dname ;
	private Boolean enable ;
	private List<Emp> emps ;
	private List<String> infos ;
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	public void setInfos(List<String> infos) {
		this.infos = infos;
	}
	public List<Emp> getEmps() {
		return emps;
	}
	public List<String> getInfos() {
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
