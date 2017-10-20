package cn.mldn.mldnspring.goods.dao;

import java.util.Set;

import cn.mldn.mldnspring.goods.api.vo.Goods;
import cn.mldn.util.dao.IBaseDAO;

public interface IGoodsDAO extends IBaseDAO<Long, Goods> {
	/**
	 * 实现商品标签关联关系的保存
	 * @param gid 商品编号
	 * @param tids 商品标签编号
	 * @return 保存成功返回true，否则返回false
	 */
	public boolean doCreateGoodsAndTag(Long gid, Set<Long> tids);
}
