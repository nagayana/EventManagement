package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.pojo.Registration;

public class RegistrationDaoImp {
	
	public boolean insertRegistration(int employeeId,int eventId) throws SQLException, ClassNotFoundException
	{
		Class.forName("org.postgresql.Driver");
		Connection connection=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eventmanagement", 
				"postgres", "admin");
		PreparedStatement pstmt = connection.prepareStatement("insert into registrations values(?,?)");
		pstmt.setInt(1, employeeId);
		pstmt.setInt(2, eventId);
		int result = pstmt.executeUpdate();
		
		if (result > 0){
				return true;
		}
		else{
				return false;
		}
	}
	
	
    public boolean deleteRegistration(int employeeId,int eventId) throws ClassNotFoundException, SQLException
    {
    	Connection connection = null;
		
		Class.forName("org.postgresql.Driver");
		connection=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eventmanagement", "postgres", "admin");
		Statement smt=connection.createStatement();
		String s="delete from registrations where employee_Id ="+employeeId+"and event_id="+eventId;
		int check=smt.executeUpdate(s);

		if (check> 0)
			return true;
		else
			return false;
    	
    }
}
