package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	static Connection con=null;
	
	

	public static Connection getMyConnection() {
		try{  
			
			Class.forName("com.mysql.cj.jdbc.Driver");   
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/academy","root","88888888");  
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		return con;
	}
	
}