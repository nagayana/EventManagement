package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationDaoImp implements RegistrationDao{
	
	@Override
	public boolean insertRegistration(int employeeId,int eventId) throws SQLException, ClassNotFoundException
	{
		Connection connection = DBConnection.getDBConnection();
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
	
	@Override
    public boolean deleteRegistration(int employeeId,int eventId) throws ClassNotFoundException, SQLException
    {
    	Connection connection = DBConnection.getDBConnection();
		PreparedStatement pStatementmt = connection.prepareStatement("delete from registrations where employee_id = ?"
				+ "and event_id = ?");
		pStatementmt.setInt(1, employeeId);
		pStatementmt.setInt(2, eventId);
		int result = pStatementmt.executeUpdate();
		if (result> 0){
			return true;
		}
		else{
			return false;
		}
    	
    }
}
