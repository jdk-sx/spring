package cn.mldn.mldnspring.goods.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.mldn.mldnspring.goods.api.vo.Item;
import cn.mldn.mldnspring.goods.dao.IItemDAO;
import cn.mldn.util.dao.abs.AbstractDAO;

@Repository
public class ItemDAO extends AbstractDAO implements IItemDAO, RowMapper<Item> {
	@Override
	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		Item vo = new Item();
		vo.setIid(rs.getLong(1));
		vo.setTitle(rs.getString(2));
		return vo;
	}

	@Override
	public List<Item> findAll()   {
		String sql = "SELECT iid,title FROM item";
		return super.jdbcTemplate.query(sql, this);
	}

	@Override
	public boolean doCreate(Item vo)  {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doEdit(Item vo){
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Item findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findAll(Long currentPage, Integer lineSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findSplit(String column, String keyWord, Long currentPage, Integer lineSize)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getSplitCount(String column, String keyWord){
		// TODO Auto-generated method stub
		return null;
	}

}
