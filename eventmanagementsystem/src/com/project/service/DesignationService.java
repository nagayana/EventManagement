package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.project.pojo.Designation;
import com.project.pojo.Employee;

public interface DesignationService {
	ArrayList<Designation> getAllDesignations(int eventId) throws ClassNotFoundException, SQLException;
	
}
