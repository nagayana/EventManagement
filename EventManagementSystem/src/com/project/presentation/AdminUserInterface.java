package com.project.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.helper.EventOperation;
import com.project.helper.UpdateEvent;
import com.project.helper.UpdateEventHelperImp;
import com.project.pojo.Attraction;
import com.project.pojo.Event;
import com.project.pojo.Food;
import com.project.pojo.GuestList;
import com.project.service.AttractionServiceImp;
import com.project.service.EventServiceImp;
import com.project.service.FoodServiceImp;
import com.project.service.GuestListServiceImp;

public class AdminUserInterface implements OrganiserUserInterface {

    Scanner sc=new Scanner(System.in);
    int choice;
    EventOperation event=new EventOperation();  
    UpdateEvent uevent=new UpdateEvent();
    EventServiceImp events=new EventServiceImp();
	ArrayList<Event> eventList = new ArrayList<>();
	UpdateEventHelperImp updateHelper = new UpdateEventHelperImp();
	
	@Override
	public void showMenu() {
		System.out.println("=========You are logged in as organiser======="+"\n1.Create an "
				+ "event\n"+"2.Delete an event\n"+"3. Show Event details\n"+"4. Update an event\n"+"Choose your choice");
	    int choice1=sc.nextInt();
		actionPerform(choice1);  
		
		 
	}

	@Override
	public void actionPerform(int choice)
	{  
		switch(choice) 
		{
		   case 1:
			   
			   int eventId= event.createNewEvent();
			   uevent.insertEventExtraDetails(eventId);
			   break;
			   
			   
		   case 2:
			   System.out.println("\n\n\nHere are the List of events");
			   try {
				       eventList = events.getAllEvents();
			       } catch (ClassNotFoundException | SQLException e) {
				       e.printStackTrace();
			       }
			    for(Event ev:eventList)
			    {
			    	System.out.println("Event Id = "+ev.getEventID());
			    }
			   System.out.println("\n\n\nEnter the event Id of event you want to delete :");
			   eventId=sc.nextInt();
			   try {
				      if(event.deleteEvent(eventId))
				    	  System.out.println("Event with eventId ="+eventId+" is deleted sucessfully.");
				      else
				    	  System.out.println("Something went wrong in the deletion of the event");
			       }
			   
			   catch (ClassNotFoundException | SQLException e) {
				      e.printStackTrace();
			       }
			   break;
			   
			   
		   case 3:
			   System.out.println("\n\n\nHere are the List of events");
			   
			   try {
				       eventList = events.getAllEvents();
			       } catch (ClassNotFoundException | SQLException e) {
				       e.printStackTrace();
			       }
			    for(Event ev:eventList)
			    {
			    	System.out.println("Event Id = "+ev.getEventID()+"   Event Nmae = "+ev.getEventName()+
			    			"    Event Location = "+ev.getEventLocation()+"    Event Time = "+ev.getEventTime()
			    			+"     Event Registration deadline = "+ev.getEventRegistrationDeadline()+"    "
			    					+ "Event MaxRegistration = "+ ev.getMaxRegistration()+"   "
			    							+ " Event Total Registration = "+ev.getCurrentRegistration());
			    }
			    
			    System.out.println("\n\nSelect an event id to see its food details,attraction details and guestlist details"
			    		+ "\nEnter the Event ID :");
			    eventId = sc.nextInt();
			    updateHelper.showAttraction(eventId);
			    updateHelper.showFood(eventId);
			    updateHelper.showGuest(eventId);
			    
			    break;
			    
			
		   case 4:
			   System.out.println("\n\n\nHere are the List of events");
			   ArrayList<Event> eventList = new ArrayList<>();
			   try {
				       eventList = events.getAllEvents();
			       } catch (ClassNotFoundException | SQLException e) {
				       e.printStackTrace();
			       }
			    for(Event ev:eventList)
			    {
			    	System.out.println("Event Id = "+ev.getEventID());
			    }
			   System.out.println("\n\n\nEnter the event Id of event you want to update :");
			   eventId=sc.nextInt();
			   try {
				      uevent.updateEvent(eventId);
			       } catch (ClassNotFoundException | SQLException e) {
				      e.printStackTrace();
			}
			   break;
			   
			default :
				System.out.println("You Have Entered a wrong Choice ");
			   
			    
			    
			   }
		
		//switch case end	
		
	}
//function action performed end
}
