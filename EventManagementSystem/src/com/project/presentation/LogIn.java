package com.project.presentation;

import java.sql.SQLException;
import java.util.Scanner;

import com.project.pojo.Employee;
import com.project.pojo.Event;
import com.project.service.AuthenticationService;

public class LogIn {
	
	public Employee signIn()
	{
		Scanner scanner = new Scanner(System.in);
		AuthenticationService authenticationService = new AuthenticationService();
		
		System.out.print("====== Welcome to Event Management System =======");
		System.out.print("Enter Employee ID : ");
		int employeeId = scanner.nextInt();
		System.out.print("Enter Password : ");
		String password = scanner.next();
		scanner.close();
		
		Employee employee = null;
		try{
			employee = authenticationService.authenticate(employeeId, password);
			return employee;
		}
		catch(SQLException|ClassNotFoundException e)
		{
			System.out.println("Error occured please try again");
		}
		return employee;
	}

}
