package com.cybage.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateCon {
	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/my1db","root","");
			
		return con;
		
	}

}
