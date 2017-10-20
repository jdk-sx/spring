package cn.mldn.util.dao.abs;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDAO {
	@Resource
	protected JdbcTemplate jdbcTemplate ;
}
