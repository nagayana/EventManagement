
package com.project.service;

import java.sql.SQLException;

import com.project.pojo.Employee;

public interface Authentication {
	
	public Employee authenticate(int userId,String password) throws SQLException,ClassNotFoundException;

}
