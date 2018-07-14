package com.project.presentation;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.helper.InputDetails;
import com.project.pojo.Event;
import com.project.service.EventService;
import com.project.service.EventServiceImp;
import com.project.service.GuestListService;
import com.project.service.GuestListServiceImp;


public class OrganiserUserInterfaceimp implements OrganiserUserInterface {
	int choice, chooseeventdetails, eventno;
	Scanner sc = new Scanner(System.in);
	Event event;
	EventService eventservice = new EventServiceImp();
	GuestListService guestservice=new GuestListServiceImp();

	@Override
	public void showmenu() {
		System.out.println("welcome to the event magement system,please" + " choose the option from the menu");
		System.out.println("1.Create new Event " + "2.Show Event Details " + "3.Update Event Details");
	}

	@Override
	public void actionPerform(int choice) {
		sc.nextInt(choice);
		this.choice = choice;
		System.out.println("You have selected choice number" + choice);
		switch (choice) {
		case 1: {
			event = InputDetails.acceptEventDetails();
			eventservice.insertEvent(event);
			break;
		}
		case 2: {
			ArrayList<Event> eventList = eventservice.getAllEvents();
			for (Event emp : eventList) {
				event.getEventID();
				event.getEventName();
			}
			System.out.println("choose the eventId of the event you want to see the details of");
			eventno = sc.nextInt();
			System.out.println("enter the type of details you want to see" + "1.show event specifications"
					+ "2.show guest list" + "3.show food list" + "4.show registration list");
			switch (chooseeventdetails) {
			case 1: {
				eventservice.getEvent(eventno);
                
			}
			case 2: {
				guestservice.generateGuestList(eventno);

			}
			}
			break;

		}
		case 3: {

		}
		}

	}

}
