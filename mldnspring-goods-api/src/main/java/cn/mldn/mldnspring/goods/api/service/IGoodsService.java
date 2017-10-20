package cn.mldn.mldnspring.goods.api.service;

import java.util.Map;
import java.util.Set;

import cn.mldn.mldnspring.goods.api.vo.Goods;

public interface IGoodsService {
	/**
	 * 进行商品信息的删除处理，调用IGoodsDAO.doEditDflag()方法
	 * @param gids 要删除的商品编号
	 * @return 如果没有商品商品或删除失败返回false 
	 */
	public boolean remove(Set<Long> gids) ;
	/**
	 * 进行商品修改前的数据查询操作，该操作要执行如下的数据层方法调用：
	 * 1、调用IItemDAO.findAll()查询所有的商品分类信息。
	 * 2、调用ITagDAO.findAll()查询所有的商品标记信息。
	 * 3、调用IGoodsDAO.findById()查询一个商品的具体信息。
	 * 4、调用IGoodsDAO.findGoodsTag()方法，查询该商品的所有标签，为了回填表单。
	 * @return 返回的数据包含有如下内容：
	 * key = allItems、value = 所有的商品分类。
	 * key = allTags、value = 所有的商品标签。
	 * key = goods、value = 要修改的商品信息
	 * key = allTids、value = 商品标签
	 */
	public Map<String,Object> preEdit(long id) ;
	/**
	 * 实现商品数据的修改处理，商品必须有标记，该操作执行如下处理：
	 * 1、实现商品数据的修改，调用IGoodsDAO.doEdit()
	 * 2、由于该商品之前已经设置过标签，那么应该先删除已有的标签信息之后再重新保存新的标签信息；
	 * 3、保存标签信息。
	 * @param vo 要追加的商品信息
	 * @param tids 表示商品的标记信息
	 * @return 修改成功返回true，否则返回false
	 */
	public boolean edit(Goods vo,Set<Long> tids);
	/**
	 * 进行商品信息的分页数据查询，如果没有查询列或查询关键字则进行整体查询
	 * @param column 查询列
	 * @param keyWord 查询关键字
	 * @param currentPage 当前页
	 * @param lineSize 每页行
	 * @return 返回的内容包含有如下信息：
	 * 1、key = allGoods、value = 全部商品信息；
	 * 2、key = allRecorders、value = 统计结果。
	 * 3、key = allItems、value = 全部的分类信息（Map集合）
	 */
	public Map<String, Object> list(String column, String keyWord, long currentPage, int lineSize) ;
	
	/**
	 * 实现商品数据的追加处理，商品必须有标记，该操作执行如下处理：
	 * 1、实现商品数据的添加，调用IGoodsDAO.doCreate()
	 * 2、如果要想追加商品标记与商品对应关系，应该获取当前增长后的ID内容。
	 * 3、获取ID成功后要保存商品与商品标记间的数据表（goods_tag）信息。
	 * @param vo 要追加的商品信息
	 * @param tids 表示商品的标记信息
	 * @return 追加成功返回true，否则返回false
	 */
	public boolean add(Goods vo,Set<Long> tids) ;
	/**
	 * 进行商品添加前的数据查询操作，该操作要执行如下的数据层方法调用：
	 * 1、调用IItemDAO.findAll()查询所有的商品分类信息。
	 * 2、调用ITagDAO.findAll()查询所有的商品标记信息。
	 * @return 返回的数据包含有如下内容：
	 * key = allItems、value = 所有的商品分类。
	 * key = allTags、value = 所有的商品标签。
	 */
	public Map<String,Object> preAdd() ;
}

