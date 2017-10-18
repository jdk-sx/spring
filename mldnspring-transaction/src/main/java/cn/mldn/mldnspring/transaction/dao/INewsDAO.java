package cn.mldn.mldnspring.transaction.dao;

import cn.mldn.mldnspring.transaction.vo.News;

public interface INewsDAO {
	public boolean doCreate(News vo) ;
	public News findById(Long nid) ;
}
