package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.pojo.Employee;
public class EmployeeDaoImp implements EmployeeDao{
	
	public ArrayList<Employee> searchEmployee(int designation_id) throws SQLException, ClassNotFoundException
	{
		Connection con = null;
		PreparedStatement pst = null;
		ArrayList<Employee> result = new ArrayList<Employee>();
		
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres","postgres","admin");
		
		pst = con.prepareStatement("select * from employeedatabase where designation_id=?");
		pst.setInt(1, designation_id);
		
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{
			Employee emp = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7));
			result.add(emp);
		}
		return result;
	}
}
