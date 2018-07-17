package com.project.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

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
			System.out.print("\n3: Exit");
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
					System.out.println("\n======= Good Bye. Thank you for using event management system =======");
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
		ArrayList<Event> registerdEvents = new EventServiceImp().getRegisteredEventsByEmployeeId(employee.getEmployeeId()); 
		if(registerdEvents.size()==0) {
			System.out.print("\n====== You have not registered for any events =======\n");
		}
		else {
			System.out.print("\n\n======= List of events you have registered for =======\n\n");
			printEvents(registerdEvents);
			System.out.print("\nEnter ID of event to cancel registration (choose one from ID column) :");
			int eventId = scanner.nextInt();	
			
			HashSet<Integer> eventIds = getEventIds(registerdEvents); 
			int count = 0;
			while(!eventIds.contains(eventId)){
				if(count==3){
					System.out.println("$$$$$$$$--- You are not a serious user. Good bye ---$$$$$$$$");
					System.exit(0);
				}
				System.out.println("Please enter a valid event ID from above list. Try Again");
				System.out.print("\nEnter ID of event to register (choose one from ID column) :");
				eventId = scanner.nextInt();
				count++;
			}
			cancelRegistration(employee.getEmployeeId(), eventId);
			System.out.println("Event cancellation successful.");
		}
	}

	private HashSet<Integer> getEventIds(ArrayList<Event> events){
		HashSet<Integer> eventIds = new HashSet<>();
		for(Event e:events){
			eventIds.add(e.getEventID());
		}
		return eventIds;		
	}
	
	private void showRegistrationMenu(Employee employee) throws SQLException,ClassNotFoundException{
		
		Scanner scanner = new Scanner(System.in);
		ArrayList<Event> unRegisterdEvents = new EventServiceImp().getUnregisteredEventsByEmployeeId(employee.getEmployeeId()); 
		if(unRegisterdEvents.size()==0) {
			System.out.print("\n====== Currently no events are open for registration =======\n");
		}
		else {
			System.out.print("\n\n======= List of events which are open for registration =======\n\n");
			printEvents(unRegisterdEvents);
			System.out.print("\nEnter ID of event to register (choose one from ID column) :");
			int eventId = scanner.nextInt();		
			int count=0;
			while(!isEventIdValid(unRegisterdEvents, eventId)){
				if(count==3){
					System.out.println("$$$$$$$$--- You are not a serious user. Good bye ---$$$$$$$$");
					System.exit(0);
				}
				System.out.println("Please enter a valid event ID from above list. Try again");
				System.out.print("\nEnter ID of event to register (choose one from ID column) :");
				eventId = scanner.nextInt();
				count++;
			}
			registerForEvent(employee.getEmployeeId(),eventId);
			System.out.println("Event registration successful.");
		}
	}
	
	private boolean isEventIdValid(ArrayList<Event> events,int eventId){
		
		HashSet<Integer> eventIds = getEventIds(events);
		return eventIds.contains(eventId);
	}
	
	private boolean cancelRegistration(int employeeId,int eventId) throws SQLException,ClassNotFoundException {
		return new RegisterServiceImp().deleteRegister(employeeId, eventId);
	}
	
	private boolean registerForEvent(int employeeId,int eventId) throws SQLException,ClassNotFoundException{
		
		return new RegisterServiceImp().insertRegister(employeeId, eventId);
	}
	
 	private void printEvents(ArrayList<Event> events){
		System.out.println("ID              Name               Location                 Time               Registration Deadline");
		for(Event event:events){
			System.out.printf("%-12d %-21s %-20s %-20s %-20s\n",event.getEventID(),event.getEventName(),event.getEventLocation(),
					event.getEventTime(),event.getEventRegistrationDeadline());
		}
		
	}
 	
 	public static void clearScreen() {  
 	    System.out.print("\033[H\033[2J");  
 	    System.out.flush();  
 	} 
	
}
