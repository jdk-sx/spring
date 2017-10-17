package cn.mldn.mldnspring.spel.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Book implements Serializable {
	private String title ;
	private String pub ;	// 出版社
	private Date pubdate ;	// 出版日期
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPub() {
		return pub;
	}
	public void setPub(String pub) {
		this.pub = pub;
	}
	public Date getPubdate() {
		return pubdate;
	}
	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}
	@Override
	public String toString() {
		return "Book [title=" + title + ", pub=" + pub + ", pubdate=" + pubdate + "]";
	}
}
