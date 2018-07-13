package com.project.dao;

import java.util.ArrayList;

import com.project.pojo.Registration;

public class RegistrationDaoImp {
	
	public boolean insertRegistration(Registration registration)
	{
		return true;
	}
	
	public ArrayList<Registration> getUserRegistrations(int userId)
	{
		return new ArrayList<Registration> ();
	}

	public ArrayList<Registration> getEventRegistrations(int eventid)
	{
		return new ArrayList<Registration>();
	}
}
