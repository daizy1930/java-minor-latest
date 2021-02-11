package com.cybage.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import org.apache.commons.dbcp2.BasicDataSource;

public class DbUtil {
	
	private static String dbUrl = "jdbc:mysql://localhost:3306/java-minor";
	private static String dbUser = "root";
	private static String dbPassword = "cybage@123";
	private static String className="com.mysql.cj.jdbc.Driver";

//	static {
//		try {
//			FileReader reader = new FileReader("db.properties");
//			Properties props = new Properties();
//			
//			props.load(reader);
//			dbUrl = props.getProperty("dbUrl");
//			dbUser = props.getProperty("dbUser");
//			dbPassword = props.getProperty("dbPassword");
//			className = props.getProperty("className");
//			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	
	
	public static Connection getCon() throws SQLException{
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		return conn;
//		BasicDataSource ds = new BasicDataSource();
//		ds.setUrl(dbUrl);
//		ds.setUsername(dbUser);
//		ds.setPassword(dbPassword);
//		ds.setMinIdle(5);
//		ds.setMaxIdle(10);
//		ds.setMaxOpenPreparedStatements(100);
//	
//		return ds.getConnection();

	}


	       
	      

	
	
}
