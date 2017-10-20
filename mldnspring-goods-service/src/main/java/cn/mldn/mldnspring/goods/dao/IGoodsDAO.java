package cn.mldn.mldnspring.goods.dao;

import java.util.List;
import java.util.Set;

import cn.mldn.mldnspring.goods.api.vo.Goods;
import cn.mldn.util.dao.IBaseDAO;

public interface IGoodsDAO extends IBaseDAO<Long, Goods> {
	/**
	 * 实现信息的逻辑删除处理
	 * @param gid
	 * @param dflag
	 * @return
	 */
	public boolean doEditDflag(Set<Long> gid,Integer dflag)  ;
	/**
	 * 根据商品编号删除掉所有的商品标签 
	 * @param gid
	 * @return
	 */
	public boolean doRemoveGoodsTag(Long gid) ; 
	
	/**
	 * 根据商品编号查询出此商品的所有标签信息
	 * @param gid
	 * @return
	 */
	public List<Long> findGoodsTag(Long gid) ;
	
	/**
	 * 实现商品标签关联关系的保存
	 * @param gid 商品编号
	 * @param tids 商品标签编号
	 * @return 保存成功返回true，否则返回false
	 */
	public boolean doCreateGoodsAndTag(Long gid, Set<Long> tids);
}
