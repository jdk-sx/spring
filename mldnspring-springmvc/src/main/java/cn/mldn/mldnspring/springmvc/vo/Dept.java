package cn.mldn.mldnspring.springmvc.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Dept implements Serializable {
	private Long deptno ;
	private String dname ;
	private Date createdate ;
	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + ", createdate=" + createdate + "]";
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
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
}
