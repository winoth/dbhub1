package com.multirechargehub.utils;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBconnect {
	private static final String URL="jdbc:mysql://localhost:3306/";
	private static final String DBNAME="DBHub";
	private static final String UNAME="root";
	private static final String PWD="root";
	private static final String DRIVER="com.mysql.jdbc.Driver";
	
	/**
	 * @return -connection object
	 */
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con=(Connection) DriverManager.getConnection(URL+DBNAME,UNAME,PWD);
		} catch (ClassNotFoundException e) {
			return null;
		} catch (SQLException e) {
			return null;
			
		}
		return con;
		
	}

}
