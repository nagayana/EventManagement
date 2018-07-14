package com.project.presentation;

import com.project.pojo.Employee;

public class CUI {
	public void run()
	{
		LogIn logIn = new LogIn();
		Employee employee = logIn.signIn();
		if(employee!=null)
		{
			startSession(employee);
		}
		else{
			System.out.println("Wrong password. please try again");
		}
	}
	
	private void startSession(Employee employee)
	{
		if(employee.getType().equalsIgnoreCase("user"))
		{
			new GuestUserInterfaceImp().showMenu(employee.getDesignationId());
		}
	}

}
