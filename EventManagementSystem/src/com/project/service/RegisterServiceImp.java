package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.project.dao.EventDaoImp;
import com.project.dao.RegistrationDaoImp;
import com.project.pojo.Registration;

public class RegisterServiceImp implements RegisterService {

	@Override
	public boolean insertRegister(int employeeId,int eventId) throws ClassNotFoundException, SQLException {
		
		boolean result1 = new RegistrationDaoImp().insertRegistration(employeeId,eventId);
		boolean result2 = new EventDaoImp().incrementCurrentRegistration(eventId);
		return (result1 && result2);
	}

	@Override
	public boolean deleteRegister(int employeeId, int eventId) throws ClassNotFoundException, SQLException {
	
		boolean result1 = new RegistrationDaoImp().deleteRegistration(employeeId, eventId);
		boolean result2 = new EventDaoImp().decrementCurrentRegistration(eventId);
		return (result1 && result2);
	}

	@Override
	public ArrayList<Registration> getRegistrationList() {
		
		return null;
	}

}
