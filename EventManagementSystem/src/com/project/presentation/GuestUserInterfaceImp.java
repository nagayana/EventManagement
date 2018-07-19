package com.project.presentation;

import java.sql.SQLException;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.imageio.event.IIOReadWarningListener;

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
			System.out.println("\n====== You are logged in as "+employee.getFirstName()+" "+employee.getLastName()+" ======");
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
				else if(choice==3){
					System.out.println("\n======= Good Bye. Thank you for using event management system =======");
					System.exit(0);
				}
				else {
					System.out.println("Please enter a valid option. Try again");
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
			int eventId = validateUserInput(true);	
			
			HashSet<Integer> eventIds = getEventIds(registerdEvents); 
			int count = 0;
			while(!eventIds.contains(eventId)){
				if(count==3){
					System.out.println("$$$$$$$$--- You are not a serious user. Good bye ---$$$$$$$$");
					System.exit(0);
				}
				System.out.println("Please enter a valid event ID from above list. Try Again");
				System.out.print("\nEnter ID of event to cancel registration (choose one from ID column) :");
				eventId = validateUserInput(true);
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
			int eventId = validateUserInput(false);		
			int count=0;
			while(!isEventIdValid(unRegisterdEvents, eventId)){
				if(count==3){
					System.out.println("$$$$$$$$--- You are not a serious user. Good bye ---$$$$$$$$");
					System.exit(0);
				}
				System.out.println("Please enter a valid event ID from above list. Try again");
				System.out.print("\nEnter ID of event to register (choose one from ID column) :");
				eventId = validateUserInput(false);
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
			System.out.printf("%-12d %-21s %-16s %-32s %-20s\n",event.getEventID(),event.getEventName(),event.getEventLocation(),
					event.getEventTime().toLocalDate()+", "+event.getEventTime().toLocalTime(),
					event.getEventRegistrationDeadline().toLocalDate());
		}
		
	}
 	
 	private int validateUserInput(boolean flag) {
 		String string = "\nEnter ID of event to register (choose one from ID column) : ";
 		if(flag) {
 			string = "\nEnter ID of event to cancel registration (choose one from ID column) :";
 		}
 		
 		while(true) {
 			Scanner scanner = new Scanner(System.in);
 			try {
 				int input = scanner.nextInt();
 				return input;
 			}
 			catch(Exception e) {
 				System.out.println("Input mismatch. Please enter an integer value");
 				System.out.print(string);
 			}
 		}
 	}
	
}
