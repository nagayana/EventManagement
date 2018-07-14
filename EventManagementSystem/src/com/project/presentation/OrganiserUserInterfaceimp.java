package com.project.presentation;

import java.util.ArrayList;
import java.util.Scanner;

import com.project.helper.InputDetails;
import com.project.pojo.Event;
import com.project.pojo.GuestList;
import com.project.service.DesignationService;
import com.project.service.DesignationServiceImp;
import com.project.service.EventService;
import com.project.service.EventServiceImp;
import com.project.service.GuestListService;
import com.project.service.GuestListServiceImp;

public class OrganiserUserInterfaceimp implements OrganiserUserInterface {
	int chooseeventdetails, eventno, option;
	Scanner sc = new Scanner(System.in);
	Event event;
	GuestList guest;
	EventService eventservice = new EventServiceImp();
	GuestListService guestservice = new GuestListServiceImp();
	DesignationService designation = new DesignationServiceImp();

	@Override
	public void showMenu() {
		System.out.println("welcome to the event magement system,please" + " choose the option from the menu");
		System.out.println("1.Create new Event " + "2.Show Event Details " + "3.Update Event Details");
	}

	@Override
	public void actionPerform(int choice) {

		System.out.println("You have selected choice number" + choice);
		switch (choice) {
		case 1: {
			event = InputDetails.acceptEventDetails();
			eventservice.insertEvent(event);
			System.out.println("Do you want to add anything or exit"
					+ "press 1 for updating details and 2. for showing  menu again" + "3. for exit");
			option = sc.nextInt();
			if (option == 1) {
				actionPerform(3);
			} else if (option == 2) {
				showMenu();
			}

			else
				System.exit(0);

			break;

		}
		case 2: {
			ArrayList<Event> eventList = eventservice.getAllEvents();
			for (Event emp : eventList) {
				emp.getEventID();
				emp.getEventName();
			}
			System.out.println("choose the eventId of the event you want to see the details of");
			eventno = sc.nextInt();
			System.out.println("enter the type of details you want to see" + "1.show event specifications"
					+ "2.show guest list" + "3.show food list" + "4.show registration list");
			switch (chooseeventdetails) {
			case 1: {
				eventservice.getEvent(eventno);
				break;
			}
			case 2: {
				if(guestservice.generateGuestList(eventno).isEmpty()){
					System.out.println("guest list is empty");
					System.out.println("do you want to add to guest List?"
							+ "1. for adding to guest List 2. to show menu"
							+ " exit");
					int chooseForGuestList=sc.nextInt();
					if(chooseForGuestList==1){
						
						//show kra designation
						System.out.println("which designations you want to add");
						int designationId=sc.nextInt();
						int eventId=sc.nextInt();
						guestservice.insertGuestList(designationId,eventId) ;
						
					}
					else if(chooseForGuestList==2){
						
						
					}
				}
				
					break;
			}
			
		

		
		case 3: {

		} 
		}
		}

	}

}
}
