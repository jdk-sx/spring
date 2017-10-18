package cn.mldn.mldnspring.transaction.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.mldnspring.transaction.dao.INewsDAO;
import cn.mldn.mldnspring.transaction.service.INewsService;
import cn.mldn.mldnspring.transaction.vo.News;

@Service
public class NewsServiceImpl implements INewsService {
	@Resource
	private INewsDAO newsDAO;

	@Override
	public boolean add(News vo) {
		return this.newsDAO.doCreate(vo);
	}

	@Override
	public News get(long nid) {
		return this.newsDAO.findById(nid);
	}

}
