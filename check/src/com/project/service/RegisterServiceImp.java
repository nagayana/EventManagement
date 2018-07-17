package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.project.dao.RegistrationDaoImp;
import com.project.pojo.Registration;

public class RegisterServiceImp implements RegisterService {

	@Override
	public boolean insertRegister(int employeeId,int eventId) throws ClassNotFoundException, SQLException {
		RegistrationDaoImp registration=new RegistrationDaoImp();
		return registration.insertRegistration(employeeId,eventId);
	}

	@Override
	public boolean deleteRegister(int employeeId, int eventId) throws ClassNotFoundException, SQLException {
		RegistrationDaoImp registration=new RegistrationDaoImp();
		return registration.deleteRegistration(employeeId, eventId);
	}

	@Override
	public ArrayList<Registration> getRegistrationList() {
		
		return null;
	}

}
