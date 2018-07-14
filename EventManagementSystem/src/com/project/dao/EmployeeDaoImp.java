package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.project.pojo.Employee;

public class EmployeeDaoImp implements EmployeeDao{
	@Override
	public Integer getNumberOfEmployeesByDesignation(int designation_id) throws SQLException, ClassNotFoundException
	{
		Connection con = DBConnection.getDBConnection();
		PreparedStatement pst = con.prepareStatement("select count(*) from employeedatabase where designation_id = ?");
		pst.setInt(1, designation_id);
		
		ResultSet rs = pst.executeQuery();
		Integer numberOfEmployees = null;
		if(rs.next())
		{
			numberOfEmployees = rs.getInt(1);
		}
		return numberOfEmployees;
	}
	
	
	@Override
	public Employee getEmployeeById(int employee_id) throws SQLException,ClassNotFoundException
	{
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pStatement = connection.prepareStatement("select * from employeedatabase where employee_id = ?");
		pStatement.setInt(1, employee_id);
		ResultSet rs = pStatement.executeQuery();
		
		Employee employee = null;
		if(rs.next())
		{
			employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), 
					rs.getString(5), rs.getString(6), rs.getString(7));
		}
		return employee;
	}
}
