package com.project.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.project.pojo.Employee;

public interface EmployeeDao {
	ArrayList<Employee> searchEmployee(int designationId) throws SQLException,ClassNotFoundException;
}
