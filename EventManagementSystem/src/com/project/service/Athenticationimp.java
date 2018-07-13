 package com.project.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.project.pojo.Event;

public class Athenticationimp implements Authentication {
	String enteredPassword;

	@Override
	public boolean authenticate(String userId, String password) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		this.enteredPassword = password;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
					"admin");
			pstmt = connection.prepareStatement("select password from employeesdatabse where userId=?");
			pstmt.setString(1, userId);
			ResultSet rs = pstmt.executeQuery();

			if (rs.getString(1) ==enteredPassword) {
				return true;
			}
			
		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// 5.close the connection
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return false;

	}

}
