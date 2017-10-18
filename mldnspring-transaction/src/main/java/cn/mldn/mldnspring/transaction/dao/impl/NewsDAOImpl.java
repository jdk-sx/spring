package cn.mldn.mldnspring.transaction.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import cn.mldn.mldnspring.transaction.dao.INewsDAO;
import cn.mldn.mldnspring.transaction.vo.News;

@Repository
public class NewsDAOImpl implements INewsDAO {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean doCreate(News vo) {
		String sql = "INSERT INTO news(title,pubdate,note,price,readcount) VALUES (?,?,?,?,?)";
		int len = this.jdbcTemplate.update(sql, vo.getTitle(), vo.getPubdate(), vo.getNote(), vo.getPrice(),
				vo.getReadcount()); // 更新操作
		return len > 0;
	}

	@Override
	public News findById(Long nid) {
		String sql = "SELECT nid,title,pubdate,note,price,readcount FROM news WHERE nid=?";
		News vo = this.jdbcTemplate.queryForObject(sql, new Object[] { nid }, new RowMapper<News>() {
			@Override 
			public News mapRow(ResultSet rs, int rowNum) throws SQLException {
				News vo = new News();
				vo.setNid(rs.getLong(1));
				vo.setTitle(rs.getString(2));
				vo.setPubdate(rs.getDate(3));
				vo.setNote(rs.getString(4));
				vo.setPrice(rs.getDouble(5));
				vo.setReadcount(rs.getInt(6));
				return vo;
			}
		});
		return vo;
	}

}
