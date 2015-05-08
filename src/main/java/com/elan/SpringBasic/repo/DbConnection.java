package com.elan.SpringBasic.repo;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DbConnection {
	
	private static final String DB_DRIVER = "org.gjt.mm.mysql.Driver";
	private static final String DB_CONNECTION = "JDBC:Mysql://localhost:3306/athena";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "password";

	static {
		try {
 			Class.forName(DB_DRIVER);
 		} catch (ClassNotFoundException e) {
 			System.out.println(e.getMessage());
 		}
	}
	
	public static Connection getDBConnection() {
		 
		Connection dbConnection = null;
 		try {
			dbConnection = (Connection) DriverManager.getConnection(DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return dbConnection;
	}
}
