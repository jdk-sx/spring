package cn.mldn.mldnspring.goods.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.mldnspring.goods.api.service.IGoodsService;
import cn.mldn.mldnspring.goods.api.vo.Goods;
import cn.mldn.mldnspring.goods.dao.IItemDAO;
import cn.mldn.mldnspring.goods.dao.ITagDAO;
import cn.mldn.util.service.abs.AbstractService;

@Service
public class GoodsServiceImpl extends AbstractService implements IGoodsService {
	@Resource
	private IItemDAO itemDAO;
	@Resource
	private ITagDAO tagDAO;
	@Override
	public Map<String, Object> preAdd() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("allItems", this.itemDAO.findAll()) ;
		map.put("allTags", this.tagDAO.findAll()) ;
		return map; 
	}

	@Override
	public boolean remove(Set<Long> gids)  {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> preEdit(long id){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean edit(Goods vo, Set<Long> tids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> list(String column, String keyWord, long currentPage, int lineSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Goods vo, Set<Long> tids) {
		// TODO Auto-generated method stub
		return false;
	}

}
