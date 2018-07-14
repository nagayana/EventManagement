package com.project.dao;

import java.sql.SQLException;

public interface RegistrationDao {
	public boolean insertRegistration(int employeeId,int eventId) throws SQLException, ClassNotFoundException;
	public boolean deleteRegistration(int employeeId,int eventId) throws SQLException, ClassNotFoundException;
}
