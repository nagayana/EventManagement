package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection connection;
	private static DBConnection dbConnection;
	
	private DBConnection() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eventmanagement","postgres","admin");
	}

	public static Connection getDBConnection() throws ClassNotFoundException, SQLException{
		if(dbConnection==null || connection.isClosed())
		{
			dbConnection = new DBConnection();
		}
		return connection; 
	}
}
