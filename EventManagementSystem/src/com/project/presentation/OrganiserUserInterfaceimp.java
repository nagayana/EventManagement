package com.project.presentation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.helper.InputDetails;
import com.project.pojo.Event;
import com.project.pojo.Food;
import com.project.pojo.GuestList;
import com.project.service.DesignationService;
import com.project.service.DesignationServiceImp;
import com.project.service.EventService;
import com.project.service.EventServiceImp;
import com.project.service.FoodDatabaseServiceImp;
import com.project.service.FoodService;
import com.project.service.FoodServiceImp;
import com.project.service.GuestListService;
import com.project.service.GuestListServiceImp;

public class OrganiserUserInterfaceimp implements OrganiserUserInterface {
	int chooseeventdetails, eventno, option;
	Scanner sc = new Scanner(System.in);
	Event event;
	GuestList guest;
	EventService eventservice = new EventServiceImp();
	GuestListService guestservice = new GuestListServiceImp();
	DesignationService designationservice = new DesignationServiceImp();
	FoodService foodservice=new FoodServiceImp(); 
	FoodDatabaseServiceImp foodDBservice= new FoodDatabaseServiceImp();

	@Override
	public void showMenu() {
		System.out.println("welcome to the event magement system,please" + " choose the option from the menu");
		System.out.println("1.Create new Event " + "2.Show Event Details " + "3.Update Event Details");
		int choice=sc.nextInt();
		actionPerform(choice);
	}

	@Override
	public void actionPerform(int choice) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
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
				System.out.print("\nevent id" +emp.getEventID() + "event name" +emp.getEventName());
			}
			System.out.println("choose the eventId of the event you want to see the details of");
			eventno = sc.nextInt();
			
			System.out.println("enter the type of details you want to see" + "1.show event specifications"
					+ "2.show guest list" + "3.show food list" + "4.show registration list +5.show attraction list");
			chooseeventdetails=sc.nextInt();
			switch (chooseeventdetails) {
			case 1: {
				System.out.println("envent details are" +eventservice.getEvent(eventno));
				
				break;
			}
			case 2: {
				try {
					if (guestservice.generateGuestList(eventno).isEmpty()) {
						System.out.println("guest list is empty");
						System.out.println("do you want to add to guest List?"
								+ "1. for adding to guest List 2. to show menu" + " 3.exit");
						int chooseForGuestList = sc.nextInt();
						if (chooseForGuestList == 1) {

							try {
								System.out.println("designations are " +designationservice.getAllDesignations());
							} catch (ClassNotFoundException | SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							boolean addtoGuestList = true;
							while (addtoGuestList) {
								System.out.println("which designations you want to add");
								int designationId = sc.nextInt();
								
								try {
									guestservice.insertGuestList(designationId, eventno);
								} catch (ClassNotFoundException | SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								System.out.println("do you want to add more? 1.yes 2.no");
								int addMore = sc.nextInt();
								if (addMore == 1) {
									addtoGuestList = true;
								} else
									addtoGuestList = false;
							}

						} else if (chooseForGuestList == 2) {
							showMenu();

						} else
							System.exit(0);
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			}

			case 3: {
				try {
					System.out.println("food list is" +foodDBservice.generateFoodList());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					if (foodservice.searchFoodList(eventno).isEmpty()) {
						System.out.println("foodList list is empty");
						System.out.println("do you want to add to food List?"
								+ "1. for adding to food List 2. to show menu" + " 3.exit");
						int chooseForFoodList = sc.nextInt();
						if (chooseForFoodList == 1) {
							boolean addtoFoodList = true;
							while (addtoFoodList) {
						//		foodservice.insertFood(food); 
								System.out.println("do you want to add more? 1.yes 2.no");
								int addMore = sc.nextInt();
								if (addMore == 1) {
									addtoFoodList = true;
								} else
									addtoFoodList = false;
							}

						} else if (chooseForFoodList == 2) {
							showMenu();

						} else
							System.exit(0);
					}
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}
			case 4:
			}
		}

		}

	}*/
}
