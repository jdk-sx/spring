package cn.mldn.mldnspring.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import cn.mldn.mldnspring.jdbc.vo.News;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class) // 设置要使用的测试工具
public class TestJDBCDemo extends TestCase {
	@Resource
	private JdbcTemplate jdbcTemplate; // 注入JdbcTemplate对象
	@Test
	public void testSelectCount() {
		
		String column = "title";
		String keyWord = "中国";
		String sql = "SELECT COUNT(*) FROM news WHERE " + column + " LIKE ?";
		Long count = this.jdbcTemplate.queryForObject(sql, Long.class, "%"+keyWord+"%") ;
		System.err.println("数据量统计：" + count);
	} 
	
	@Test
	public void testSelectSplit() {
		String column = "title";
		String keyWord = "中国";
		Long currentPage = 1L;
		Integer lineSize = 5;
		String sql = "SELECT nid,title,pubdate,note,price,readcount FROM news WHERE " + column + " LIKE ? LIMIT ?,?";
		List<News> allNews = this.jdbcTemplate.query(sql,
				new Object[] { "%" + keyWord + "%", (currentPage - 1) * lineSize, lineSize }, new RowMapper<News>() {
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
		System.out.println(allNews);
	}
 
	@Test
	public void testSelectObject() {
		String sql = "SELECT nid,title,pubdate,note,price,readcount FROM news WHERE nid=?";
		News vo = this.jdbcTemplate.queryForObject(sql, new Object[] { 5 }, new RowMapper<News>() {
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
		System.out.println(vo);
	}

	@Test
	public void testBatch() { // 实现批量增加信息
		String sql = "INSERT INTO news(title,pubdate,note,price,readcount) VALUES (?,?,?,?,?)";
		List<News> allNews = new ArrayList<News>();
		Random rand = new Random();
		for (int x = 0; x < 10; x++) {
			News vo = new News();
			vo.setTitle("中国万岁，中国腾飞 - " + x);
			vo.setNote("中国梦 - " + x);
			vo.setPubdate(new Date());
			vo.setPrice(999.00);
			vo.setReadcount(rand.nextInt(99999999));
			allNews.add(vo);
		}
		int len[][] = this.jdbcTemplate.batchUpdate(sql, allNews, allNews.size(),
				new ParameterizedPreparedStatementSetter<News>() {
					@Override
					public void setValues(PreparedStatement ps, News vo) throws SQLException {
						ps.setString(1, vo.getTitle());
						ps.setDate(2, new java.sql.Date(vo.getPubdate().getTime()));
						ps.setString(3, vo.getNote());
						ps.setDouble(4, vo.getPrice());
						ps.setInt(5, vo.getReadcount());
					}
				});
		for (int x = 0; x < len.length; x++) {
			System.out.println("【" + x + "】更新记录：" + Arrays.toString(len[x]));
		}
	}

	@Test
	public void testDelete() {
		String sql = "DELETE FROM news WHERE nid=?";
		long nid = 2;
		int len = this.jdbcTemplate.update(sql, nid); // 更新操作
		System.out.println("更新行数：" + len);
		TestCase.assertEquals(len, 1); // 更新一行数据
	}

	@Test
	public void testEdit() {
		String sql = "UPDATE news SET title=?,pubdate=?,note=?,price=?,readcount=? WHERE nid=?";
		String title = "今天下雨了，记得及时收衣服";
		Date pubdate = new Date();
		String note = "老子就不收，爱收不收。";
		double price = 12.0;
		int readcount = 50000;
		long nid = 3;
		int len = this.jdbcTemplate.update(sql, title, pubdate, note, price, readcount, nid); // 更新操作
		System.out.println("更新行数：" + len);
		TestCase.assertEquals(len, 1); // 更新一行数据
	}

	@Test
	public void testAdd2() {
		String sql = "INSERT INTO news(title,pubdate,note,price,readcount) VALUES (?,?,?,?,?)";
		String title = "热烈清楚人民大会召开";
		Date pubdate = new Date();
		String note = "全国人民喜迎大会，全国积极投入安全防范";
		double price = 1.0;
		int readcount = 500000;
		int len = this.jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, title);
				ps.setDate(2, new java.sql.Date(pubdate.getTime()));
				ps.setString(3, note);
				ps.setDouble(4, price);
				ps.setInt(5, readcount);
			}
		});
		System.out.println("更新行数：" + len);
		TestCase.assertEquals(len, 1); // 更新一行数据
	}

	@Test
	public void testAdd3() {
		KeyHolder keyHolder = new GeneratedKeyHolder(); // 获得增长后的ID数据
		String sql = "INSERT INTO news(title,pubdate,note,price,readcount) VALUES (?,?,?,?,?)";
		String title = "热烈清楚人民大会召开";
		Date pubdate = new Date();
		String note = "全国人民喜迎大会，全国积极投入安全防范";
		double price = 1.0;
		int readcount = 500000;
		int len = this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, title);
				ps.setDate(2, new java.sql.Date(pubdate.getTime()));
				ps.setString(3, note);
				ps.setDouble(4, price);
				ps.setInt(5, readcount);
				return ps; // 手工创建Statement对象
			}
		}, keyHolder); // 实现更新处理，随后获取对象的内容
		System.out.println("更新行数：" + len + "、当前的新闻ID：" + keyHolder.getKey());
		TestCase.assertEquals(len, 1); // 更新一行数据
	}

	@Test
	public void testAdd1() {
		String sql = "INSERT INTO news(title,pubdate,note,price,readcount) VALUES (?,?,?,?,?)";
		String title = "热烈清楚人民大会召开";
		Date pubdate = new Date();
		String note = "全国人民喜迎大会，全国积极投入安全防范";
		double price = 1.0;
		int readcount = 500000;
		int len = this.jdbcTemplate.update(sql, title, pubdate, note, price, readcount); // 更新操作
		System.out.println("更新行数：" + len);
		TestCase.assertEquals(len, 1); // 更新一行数据
	}
}
