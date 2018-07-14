package com.project.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.pojo.Event;
import com.project.service.EventServiceImp;
import com.project.service.RegisterServiceImp;

public class GuestUserInterfaceImp implements GuestUserInterface {
	
	private int choice;
	private Scanner sc=new Scanner(System.in);
	public void showMenu()
	{
		System.out.println("WELCOME TO THE EVENT MANAGEMENT SYSTEM\n\n"
				+"HERE IS THE EVENT LIST");
		EventServiceImp events=new EventServiceImp();
    	ArrayList<Event> eventList=new ArrayList<>();
    	for(Event event:eventList)
    	{
    		System.out.println(event);
    	}
    	
    	System.out.println("PLEASE ENTER YOUR CHOICES \n1. CANCEL YOUR REGISTRATION FOR ANY EVENT\n "
    			+ "2. REGISTER FOR ANY EVENT");
		
	}
	
	public void actionPerformed(int employeeId)
	{
		choice=sc.nextInt();	
		int eventId;
		RegisterServiceImp obj=new RegisterServiceImp();
	    switch(choice)
	    {
	        case 1:
	            System.out.println("ENTER THE ID OF EVENT FOR WHICH YOU WANT TO CANCEL YOUR REGISTER :");
	            eventId=sc.nextInt();
	            obj=new RegisterServiceImp();
			try {
				obj.deleteRegister(employeeId, eventId);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	           
	            
	        case 2:
	        	System.out.println("ENTER THE ID OF EVENT FOR WHICH YOU WANT TO REGISTER");
	        	eventId=sc.nextInt();
	            obj=new RegisterServiceImp();
			    try {
				       obj.insertRegister(employeeId,eventId);
			        } catch (ClassNotFoundException | SQLException e) {
				             e.printStackTrace();
			        }
	        	
	        default:
	        	System.out.println("ENTERED A WRONG CHOICE");
	        	
	        	
	        	
	        	
	        	
	    }
	    
	}   
	

}
