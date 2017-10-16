package cn.mldn.mldnspring.di.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@SuppressWarnings("serial")
public class Dept implements Serializable {
	private Long deptno ;
	private String dname ;
	private Boolean enable ;
	private Set<String> infos ;
	private List<String> msgs ;
	public void setInfos(Set<String> infos) {
		this.infos = infos;
	}
	public void setMsgs(List<String> msgs) {
		this.msgs = msgs;
	}
	public Set<String> getInfos() {
		return infos;
	}
	public List<String> getMsgs() {
		return msgs;
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
