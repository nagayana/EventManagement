package com.project.dao;

import java.sql.SQLException;
import com.project.pojo.Employee;

public interface EmployeeDao {
	Integer getNumberOfEmployeesByDesignation(int designationId) throws SQLException,ClassNotFoundException;
	Employee getEmployeeById(int employee_id) throws SQLException,ClassNotFoundException;
}
