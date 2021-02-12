package com.cybage.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.controller.AdminController;

@SuppressWarnings("unused")
public class DbUtil {
	public static final Logger log = LogManager.getLogger(AdminController.class.getName());
	private static String className = "com.mysql.cj.jdbc.Driver";	
	private static String dbUrl;
	private static String dbUser;
	private static String dbPass;
	
	static {  
		//If want to execute something during class loading
		try {
			FileReader reader = new FileReader("D:\\db.properties");
			Properties props = new Properties();
			
			props.load(reader); //Load into the properties file as a key-value pair
			dbUrl = props.getProperty("dbUrl");
			dbUser = props.getProperty("dbUser");
			dbPass = props.getProperty("dbPass");			
		} catch (Exception e) {
			log.error("Error:" + e.getLocalizedMessage());
		}
	}

	@SuppressWarnings("resource")
	public static Connection getCon() throws SQLException{
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(dbUrl);
		ds.setUsername(dbUser);
		ds.setPassword(dbPass);
		ds.setMinIdle(5);
		ds.setMaxIdle(10);
		ds.setMaxOpenPreparedStatements(100);
		return ds.getConnection();
	}
}
