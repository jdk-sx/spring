package cn.mldn.mldnspring.goods.api.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Tag implements Serializable {
	private Long tid ;
	private String title ;
	public Long getTid() {
		return tid;
	}
	public void setTid(Long tid) {
		this.tid = tid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
