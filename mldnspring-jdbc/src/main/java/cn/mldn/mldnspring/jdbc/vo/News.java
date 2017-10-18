package cn.mldn.mldnspring.jdbc.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class News implements Serializable {
	private Long nid ;
	private String title ;
	private Date pubdate ;
	private Double price ;
	private String note ;
	private Integer readcount ;
	public void setNote(String note) {
		this.note = note;
	}
	public String getNote() {
		return note;
	}
	public Long getNid() {
		return nid;
	}
	public void setNid(Long nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getReadcount() {
		return readcount;
	}
	public void setReadcount(Integer readcount) {
		this.readcount = readcount;
	}
	@Override
	public String toString() {
		return "News [nid=" + nid + ", title=" + title + ", pubdate=" + pubdate + ", price=" + price + ", note=" + note
				+ ", readcount=" + readcount + "]";
	} 
}
