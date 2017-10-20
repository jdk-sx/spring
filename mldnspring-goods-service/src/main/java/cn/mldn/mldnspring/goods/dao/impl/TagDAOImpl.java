package cn.mldn.mldnspring.goods.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.mldn.mldnspring.goods.api.vo.Tag;
import cn.mldn.mldnspring.goods.dao.ITagDAO;
import cn.mldn.util.dao.abs.AbstractDAO;
@Repository
public class TagDAOImpl extends AbstractDAO implements ITagDAO,RowMapper<Tag> {
	@Override
	public List<Tag> findAll() {
		String sql = "SELECT tid,title FROM tag" ;
		return super.jdbcTemplate.query(sql, this);
	}
	@Override
	public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tag vo = new Tag() ;
		vo.setTid(rs.getLong(1));
		vo.setTitle(rs.getString(2));
		return vo;
	}
	
	@Override
	public boolean doCreate(Tag vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doEdit(Tag vo)  {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Long id)  {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids)  {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Tag findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Tag> findAll(Long currentPage, Integer lineSize)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Tag> findSplit(String column, String keyWord, Long currentPage, Integer lineSize)  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getAllCount()  {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long getSplitCount(String column, String keyWord)   {
		// TODO Auto-generated method stub
		return null;
	}

}
