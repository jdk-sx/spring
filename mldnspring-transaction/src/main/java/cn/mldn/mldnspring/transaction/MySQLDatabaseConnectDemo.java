package cn.mldn.mldnspring.transaction;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.lang.Nullable;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;


public class MySQLDatabaseConnectDemo {
	public static final String DRIVER = "org.gjt.mm.mysql.Driver" ;
	public static final String URL = "jdbc:mysql://localhost:3306/mldn" ;
	public static final String USERNAME = "root" ;
	public static final String PASSWORD = "mysqladmin" ;
	public static void main(String[] args) throws Exception {
		
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource() ;
		dataSource.setDriverClassName(DRIVER); 
		dataSource.setUrl(URL);
		dataSource.setUsername(USERNAME);
		dataSource.setPassword(PASSWORD);
		System.out.println(dataSource.getConnection());
		dataSource.getConnection().close(); 
	}
}
