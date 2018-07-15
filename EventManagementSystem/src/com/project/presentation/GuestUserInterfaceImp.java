package com.project.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.pojo.Employee;
import com.project.pojo.Event;
import com.project.service.EventServiceImp;
import com.project.service.RegisterServiceImp;

public class GuestUserInterfaceImp implements GuestUserInterface {
	
	@Override
	public void showMenu(Employee employee)
	{	
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			
			System.out.println("\n====== You are logged in as a User ======");
			System.out.print("1: Register for event");
			System.out.print("\n2: Cancel registration");
			System.out.print("\n3. Exit");
			System.out.print("\n\nEnter your choice : ");
			
			
			int choice = scanner.nextInt();
			
			try {
				if(choice==1) {
					showRegistrationMenu(employee);
				}
				else if(choice==2) {
					showCancelationMenu(employee);
				}
				else {
					System.exit(0);
				}
			}
			catch(Exception e) {
				System.out.println("Error occurred. Action not performed");
				System.out.println(e+"Exception catched in GuestUserInterfaceImp.showmenu");
			}
		}	
	}
	
	private void showCancelationMenu(Employee employee) throws SQLException,ClassNotFoundException{
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Event> registerdEvenets = new EventServiceImp().getRegisteredEventsByEmployeeId(employee.getEmployeeId()); 
		if(registerdEvenets.size()==0) {
			System.out.print("\n====== You have not registered for any events =======\n");
		}
		else {
			System.out.print("\n\n======= List of events you have registered for =======\n\n");
			printEvents(registerdEvenets);
			System.out.print("\nEnter ID of event to cancel registration :");
			int eventId = scanner.nextInt();	
			cancelRegistration(employee.getEmployeeId(), eventId);
			System.out.println("Event cancelation successful.");
		}
	}
	
	private void showRegistrationMenu(Employee employee) throws SQLException,ClassNotFoundException{
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Event> unRegisterdEvenets = new EventServiceImp().getUnregisteredEventsByEmployeeId(employee.getEmployeeId()); 
		if(unRegisterdEvenets.size()==0) {
			System.out.print("\n====== Currently no events are open for registration =======\n");
		}
		else {
			System.out.print("\n\n======= List of events which are open for registration =======\n\n");
			printEvents(unRegisterdEvenets);
			System.out.print("\nEnter ID of event to register  :");
			int eventId = scanner.nextInt();		
			registerForEvent(employee.getEmployeeId(),eventId);
			System.out.println("Event registration successful.");
		}
	}
	
	private boolean cancelRegistration(int employeeId,int eventId) throws SQLException,ClassNotFoundException {
		return new RegisterServiceImp().deleteRegister(employeeId, eventId);
	}
	
	private boolean registerForEvent(int employeeId,int eventId) throws SQLException,ClassNotFoundException{
		
		return new RegisterServiceImp().insertRegister(employeeId, eventId);
	}
	
 	private void printEvents(ArrayList<Event> events){
		System.out.println("ID              Name               Location                 Time");
		for(Event event:events){
			System.out.println(event.getEventID()+"          "+event.getEventName()+"             "+event.getEventLocation()+
					"           "+event.getEventTime());
		}
		
	}
 	
 	public static void clearScreen() {  
 	    System.out.print("\033[H\033[2J");  
 	    System.out.flush();  
 	} 
	
}
