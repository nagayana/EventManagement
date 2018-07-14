package com.project.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import com.project.pojo.Event;
import com.project.service.GuestListServiceImp;
import com.project.service.RegisterServiceImp;

public class GuestUserInterfaceImp implements GuestUserInterface {
	
	@Override
	public void showMenu(int designationId)
	{		
		System.out.println("------ Your Event List ------");
		ArrayList<Event> eventList = new ArrayList<>(); 
		try{
			eventList = new GuestListServiceImp().getGuestEventList(designationId);
		}
		catch(Exception e)
		{
			System.out.println("Error occurred please try again");
		}
    	
    	for(Event event : eventList)
    	{
    		printGuestEvent(event);
    	}
    		
	}
	
	private void printGuestEvent(Event event)
	{
		System.out.print(event.getEventID()+" : "+event.getEventName());
	}
	
	public void actionPerformed(int employeeId)
	{
		Scanner sc = new Scanner(System.in);
		int choice=sc.nextInt();	
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
