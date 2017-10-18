package cn.mldn.mldnspring.transaction.service;

import cn.mldn.mldnspring.transaction.vo.News;

public interface INewsService {
	public boolean add(News vo) ;
	public News get(long nid) ;
}
