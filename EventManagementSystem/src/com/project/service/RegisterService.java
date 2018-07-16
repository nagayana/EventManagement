package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.project.pojo.Event;
import com.project.pojo.Registration;

public interface RegisterService {
	
	boolean insertRegister(int employeeId,int eventId) throws ClassNotFoundException, SQLException;
	boolean deleteRegister(int employeeId,int eventId) throws ClassNotFoundException, SQLException;
	ArrayList<Registration> getRegistrationList();

}
