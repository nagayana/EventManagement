package com.project.helper;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.project.pojo.Event;
import com.project.service.EventServiceImp;

public class UpdateEvent {
	Scanner sc=new Scanner(System.in);
	EventOperation eventOp=new EventOperation();
	EventServiceImp eventObj=new EventServiceImp();
	UpdateEventHelperImp updateEvent=new UpdateEventHelperImp();
	
	public void insertEventExtraDetails(int eventId)
	{
		int want=1;
		System.out.println("You created event with eventId "+eventId+"\n"
		   		+ "Do you want to add some more Information to the event");
		while(want==1)
		{
			System.out.println("1. Add GuestList \n 2. Add Attraction \n3. Add Food\nEnter your choice :");
			 int choice=sc.nextInt();
			   switch(choice)
			   {
			        case 1:
				         try {
					             eventOp.insertGuest(eventId); 
				             } catch (ClassNotFoundException | SQLException e1) {
					             e1.printStackTrace();
				             }
				         break;
				         
			        case 2:
				         try {
					              eventOp.insertFood(eventId);
				             } catch (ClassNotFoundException | SQLException e1) {
					             e1.printStackTrace();
				             }
				         break;
				          
			        case 3:
			        	try {
				              eventOp.insertAttraction(eventId);
			             } catch (ClassNotFoundException | SQLException e1) {
				             e1.printStackTrace();
			             }
			         break;
			         
			         default:
			        	 System.out.println("You have entered a wrong choice :");
			        	
			   }
			   
			   System.out.println("Do you want to add more informatio to the event\n If yes input 1\n "
						+ "If no press any other integer \n Enter your Choice :");
				want = sc.nextInt();

		}
		
		//end of while loop
	}
	// end of function
	
	
	//===============================================================================================================
	
	public void updateEvent(int eventId) throws ClassNotFoundException, SQLException
	{
		Event event=eventObj.getEvent(eventId);
		System.out.println("Want to update Event Location\n type 1 for 'yes' and input any other integer for 'no'");
		if(sc.nextInt()==1)
		{ 
			System.out.println("Enter New Location :"); 
			event.setEventLocation(sc.next());
		}
		System.out.println("Want to update Event Time\n type 1 for 'yes' and input any other integer for 'no'");
		if(sc.nextInt()==1)
		{
			System.out.println("Enter New Time :");
			event.setEventTime(LocalDateTime.parse(sc.next()));
		}
		System.out.println("Want to update Event registration DeadLine\n type 1 for 'yes' and input any other integer for 'no'");
		if(sc.nextInt()==1)
		{ 
			System.out.println("Enter New registration deadline :");
			event.setEventRegistrationDeadline(LocalDateTime.parse(sc.next()));
		}
		System.out.println("Want to update Event  maximum registartion number\n type 1 for 'yes' and input any other integer for 'no'");
		if(sc.nextInt()==1)
		{ 
			System.out.println("Enter New Number Of Maximum Registration :");
			event.setMaxRegistration(sc.nextInt());
		}
		eventObj.updateEvent(eventId, event);
		
		System.out.println("Want to update Guest List for the event\n type 1 for 'yes' and input any other integer for 'no'");
		if(sc.nextInt()==1)
		{
			System.out.println("1. Add a new Guest \n2. Delete a Guest\nEnter your choice :");
			switch(sc.nextInt())
			{
			case 1:
				 System.out.println("Enter the designation ID You want to enter as a guest : ");
			     updateEvent.insertNewGuest(eventId, sc.nextInt());
			     break;
			case 2:
				updateEvent.showGuest(eventId);
				System.out.println("Enter the disignation ID you want to delete : ");
				updateEvent.deleteGuest(eventId,  sc.nextInt());
				break;
				
		    default:
			   System.out.println("You entered a wrong input");
				
			}
		}
		
		
		System.out.println("Want to update Food List for the event\n type 1 for 'yes' and input any other integer for 'no'");
		if(sc.nextInt()==1)
		{
			System.out.println("1. Add a new Food \n2. Delete a Food\n3. Update a food quantity\nEnter your choice :");
			switch(sc.nextInt())
			{
			case 1:
				 updateEvent.insertFood(eventId);
			     break;
			case 2:
				updateEvent.showFood(eventId);
				System.out.println("Enter the food Name you want to delete : ");
				updateEvent.deleteFood(sc.next(), eventId);
				break;
				
			case 3:
				updateEvent.showFood(eventId);
				System.out.println("Enter the food Name you want to delete : ");
				String name=sc.next();
				System.out.println("Enter the new quantity of food : ");
				int quantity=sc.nextInt();
				updateEvent.updateFoodQuantity(name, eventId, quantity);
				break;
				
		    default:
			   System.out.println("You entered a wrong input");
				
			}
		}
		
		
		System.out.println("Want to update Attraction  for the event\n type 1 for 'yes' and input any other integer for 'no'");
		if(sc.nextInt()==1)
		{
			System.out.println("1. Add a new Attractgion \n2. Delete an Attraction\nEnter your choice :");
			switch(sc.nextInt())
			{
			case 1:
				 updateEvent.insertAttraction(eventId);
			     break;
			case 2:
				updateEvent.showAttraction(eventId);
				System.out.println("Enter the Attraction ID you want to delete : ");
				updateEvent.deleteAttraction( eventId,sc.nextInt());
				break;
				
				
		    default:
			   System.out.println("You entered a wrong input");
				
			}
		}
		
		
		
		
	}

}
