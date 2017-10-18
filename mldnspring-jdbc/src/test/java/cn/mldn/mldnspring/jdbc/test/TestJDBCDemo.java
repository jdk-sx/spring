package cn.mldn.mldnspring.jdbc.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class) // 设置要使用的测试工具
public class TestJDBCDemo extends TestCase {
	@Resource
	private JdbcTemplate jdbcTemplate ;	// 注入JdbcTemplate对象
	@Test
	public void testAdd2() { 
		String sql = "INSERT INTO news(title,pubdate,note,price,readcount) VALUES (?,?,?,?,?)" ;
		String title = "热烈清楚人民大会召开" ;
		Date pubdate = new Date() ;
		String note = "全国人民喜迎大会，全国积极投入安全防范" ;
		double price = 1.0 ;
		int readcount = 500000 ;
		int len = this.jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, title);
				ps.setDate(2, new java.sql.Date(pubdate.getTime()));
				ps.setString(3, note);
				ps.setDouble(4, price);
				ps.setInt(5, readcount); 
			}
		}) ; 
		System.out.println("更新行数：" + len);
		TestCase.assertEquals(len,1); // 更新一行数据
	} 
	
	@Test
	public void testAdd3() {  
		KeyHolder keyHolder = new GeneratedKeyHolder() ;	// 获得增长后的ID数据
		String sql = "INSERT INTO news(title,pubdate,note,price,readcount) VALUES (?,?,?,?,?)" ;
		String title = "热烈清楚人民大会召开" ;
		Date pubdate = new Date() ;
		String note = "全国人民喜迎大会，全国积极投入安全防范" ;
		double price = 1.0 ;
		int readcount = 500000 ;
		int len = this.jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql) ;
				ps.setString(1, title);
				ps.setDate(2, new java.sql.Date(pubdate.getTime()));
				ps.setString(3, note);
				ps.setDouble(4, price);
				ps.setInt(5, readcount); 
				return ps ; // 手工创建Statement对象
			}
		}, keyHolder) ;	// 实现更新处理，随后获取对象的内容
		System.out.println("更新行数：" + len + "、当前的新闻ID：" + keyHolder.getKey()); 
		TestCase.assertEquals(len,1); // 更新一行数据
	} 
	
	@Test
	public void testAdd1() { 
		String sql = "INSERT INTO news(title,pubdate,note,price,readcount) VALUES (?,?,?,?,?)" ;
		String title = "热烈清楚人民大会召开" ;
		Date pubdate = new Date() ;
		String note = "全国人民喜迎大会，全国积极投入安全防范" ;
		double price = 1.0 ;
		int readcount = 500000 ;
		int len = this.jdbcTemplate.update(sql, title,pubdate,note,price,readcount) ;	// 更新操作
		System.out.println("更新行数：" + len);
		TestCase.assertEquals(len,1); // 更新一行数据
	} 
}
