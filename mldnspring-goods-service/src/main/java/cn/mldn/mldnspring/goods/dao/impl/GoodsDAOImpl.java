package cn.mldn.mldnspring.goods.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import cn.mldn.mldnspring.goods.api.vo.Goods;
import cn.mldn.mldnspring.goods.dao.IGoodsDAO;
import cn.mldn.util.dao.abs.AbstractDAO;

@Repository
public class GoodsDAOImpl extends AbstractDAO implements IGoodsDAO, RowMapper<Goods> {
	@Override
	public boolean doEditDflag(Set<Long> gid, Integer dflag) {
		String sql = "UPDATE goods SET dflag=? WHERE gid=?";
		int[][] len = super.jdbcTemplate.batchUpdate(sql, gid, gid.size(),
				new ParameterizedPreparedStatementSetter<Long>() {
					@Override
					public void setValues(PreparedStatement ps, Long num) throws SQLException {
						ps.setInt(1, dflag);
						ps.setLong(2, num);
					}
				});
		for (int x = 0; x < len.length; x++) {
			for (int y = 0; y < len[x].length; y++) {
				if (len[x][y] <= 0) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean doRemoveGoodsTag(Long gid) {
		String sql = "DELETE FROM goods_tag WHERE gid=?";
		return super.jdbcTemplate.update(sql, gid) > 0;
	}

	@Override
	public List<Long> findGoodsTag(Long gid) {
		String sql = "SELECT tid FROM goods_tag WHERE gid=?";
		return super.jdbcTemplate.queryForList(sql, new Object[] { gid }, Long.class);
	}

	@Override
	public boolean doCreateGoodsAndTag(Long gid, Set<Long> tids) {
		String sql = "INSERT INTO goods_tag(gid,tid) VALUES (?,?)";
		int[][] len = this.jdbcTemplate.batchUpdate(sql, tids, tids.size(),
				new ParameterizedPreparedStatementSetter<Long>() {
					@Override
					public void setValues(PreparedStatement ps, Long tid) throws SQLException {
						ps.setLong(1, gid);
						ps.setLong(2, tid);
					}
				});
		for (int x = 0; x < len.length; x++) {
			for (int y = 0; y < len[x].length; y++) {
				if (len[x][y] <= 0) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean doCreate(Goods vo) {
		KeyHolder keyHolder = new GeneratedKeyHolder(); // 获得增长后的ID数据
		String sql = "INSERT INTO goods(name,price,photo,dflag,iid) VALUES (?,?,?,?,?)";
		int len = this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setDouble(2, vo.getPrice());
				ps.setString(3, vo.getPhoto());
				ps.setInt(4, vo.getDflag());
				ps.setLong(5, vo.getIid());
				return ps; // 手工创建Statement对象
			}
		}, keyHolder); // 实现更新处理，随后获取对象的内容
		vo.setGid(keyHolder.getKey().longValue()); // 将增长后的id保存在VO类中
		return len > 0;
	}

	@Override
	public boolean doEdit(Goods vo) {
		String sql = "UPDATE goods SET name=?,price=?,photo=?,iid=? WHERE gid=?";
		return super.jdbcTemplate.update(sql, vo.getName(), vo.getPrice(), vo.getPhoto(), vo.getIid(), vo.getGid()) > 0;
	}

	@Override
	public boolean doRemove(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(Set<Long> ids) {
		String sql = "";
		return false;
	}

	@Override
	public Goods findById(Long id) {
		String sql = "SELECT gid,name,price,photo,dflag,iid FROM goods WHERE dflag=0 AND gid=?";
		return super.jdbcTemplate.queryForObject(sql, new Object[] { id }, this);
	}

	@Override
	public List<Goods> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Goods mapRow(ResultSet rs, int rowNum) throws SQLException {
		Goods vo = new Goods();
		vo.setGid(rs.getLong(1));
		vo.setName(rs.getString(2));
		vo.setPrice(rs.getDouble(3));
		vo.setPhoto(rs.getString(4));
		vo.setDflag(rs.getInt(5));
		vo.setIid(rs.getLong(6));
		return vo;
	}

	@Override
	public List<Goods> findAll(Long currentPage, Integer lineSize) {
		String sql = "SELECT gid,name,price,photo,dflag,iid FROM goods WHERE dflag=0 LIMIT ?,?";
		return super.jdbcTemplate.query(sql, new Object[] { (currentPage - 1) * lineSize, lineSize }, this);
	}

	@Override
	public List<Goods> findSplit(String column, String keyWord, Long currentPage, Integer lineSize) {
		String sql = "SELECT gid,name,price,photo,dflag,iid FROM goods WHERE dflag=0 AND " + column
				+ " LIKE ? LIMIT ?,?";
		return super.jdbcTemplate.query(sql,
				new Object[] { "%" + keyWord + "%", (currentPage - 1) * lineSize, lineSize }, this);
	}

	@Override
	public Long getAllCount() {
		String sql = "SELECT COUNT(*) FROM goods WHERE dflag=0";
		return super.jdbcTemplate.queryForObject(sql, Long.class);
	}

	@Override
	public Long getSplitCount(String column, String keyWord) {
		String sql = "SELECT COUNT(*) FROM goods WHERE dflag=0 AND " + column + " LIKE ? ";
		return super.jdbcTemplate.queryForObject(sql, new Object[] { "%" + keyWord + "%" }, Long.class);
	}

}
