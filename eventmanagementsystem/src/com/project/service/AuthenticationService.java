package com.project.service;

import java.sql.SQLException;

import com.project.dao.EmployeeDaoImp;
import com.project.pojo.Employee;

public class AuthenticationService implements Authentication {
	
	@Override
	public Employee authenticate(int employee_id,String password) throws ClassNotFoundException, SQLException
	{
		EmployeeDaoImp employeeDaoImp = new EmployeeDaoImp();
		Employee employee = employeeDaoImp.getEmployeeById(employee_id);
		String storedPassword = employee.getPassword();
		if(password.equals(storedPassword)){
			return employee;
		}
		else{
			return null;
		}
	}

}
