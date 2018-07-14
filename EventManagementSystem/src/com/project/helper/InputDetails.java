package com.project.helper;

import java.util.Scanner;

import com.project.pojo.Event;

public class InputDetails {
	
	public static Event acceptEventDetails(){
		Scanner sc = new Scanner(System.in);
		Event event=new Event();
		System.out.println("Enter event ID");
		event.setEventID(sc.nextInt());
		System.out.println("Enter event Name");
		event.setEventName(sc.next());
		System.out.println("enter event location");
		event.setEventLocation(sc.next());
		System.out.println("enter event time");
		event.setEventTime(sc.next());
		event.setEventRegistrationDeadline(null);
		event.setMaxRegistration(0);
		event.setCurrentRegistration(0);
		return event;
		
		
		
		
	}

}
