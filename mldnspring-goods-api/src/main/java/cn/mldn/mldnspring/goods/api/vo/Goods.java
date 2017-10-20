package cn.mldn.mldnspring.goods.api.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Goods implements Serializable {
	private Long gid ;
	private String name ;
	private Double price ;
	private String photo ;
	private Integer dflag ;
	private Long iid ;
	public Long getGid() {
		return gid;
	}
	public void setGid(Long gid) {
		this.gid = gid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Integer getDflag() {
		return dflag;
	}
	public void setDflag(Integer dflag) {
		this.dflag = dflag;
	}
	public Long getIid() {
		return iid;
	}
	public void setIid(Long iid) {
		this.iid = iid;
	}
}
