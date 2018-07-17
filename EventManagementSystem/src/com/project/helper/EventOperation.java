package com.project.helper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.pojo.Attraction;
import com.project.pojo.Designation;
import com.project.pojo.Event;
import com.project.pojo.Food;
import com.project.pojo.FoodDatabase;
import com.project.service.AttractionServiceImp;
import com.project.service.DesignationServiceImp;
import com.project.service.EventServiceImp;
import com.project.service.FoodDatabaseServiceImp;
import com.project.service.FoodServiceImp;
import com.project.service.GuestListServiceImp;

public class EventOperation {
	
	EventServiceImp eventService = new EventServiceImp();
	AttractionServiceImp attractionService = new AttractionServiceImp();
	GuestListServiceImp guestService = new GuestListServiceImp();
	FoodServiceImp foodService = new FoodServiceImp();
	FoodDatabaseServiceImp foodDatabaseService = new FoodDatabaseServiceImp();
	DesignationServiceImp designationService = new DesignationServiceImp();
	Scanner sc=new Scanner(System.in);
	InputDetails input=new InputDetails();
	
	//==================================================================================
	public int createNewEvent()
	{
		Event event = input.acceptEventDetails();
		try {
			   
			   eventService.insertEvent(event);
		} catch (ClassNotFoundException | SQLException e) { 
			e.printStackTrace();
		}
		
		return event.getEventID(); 
		
	}
	
	
	
	//=============================================================================
	public boolean deleteEvent(int eventId) throws ClassNotFoundException, SQLException
	{
		if(foodService.deleteFoodByEventId(eventId) && guestService.deleteGuestListByEventId(eventId)
				&& attractionService.deleteAttractionByEvenetId(eventId) && eventService.deleteEvent(eventId))
			return true;
		else
		    return false;
			
	}
	
	//===================================================================================
	
	public void insertGuest(int eventId) throws ClassNotFoundException, SQLException
	{
		int want=1;
		System.out.println("Here is the list of designation from where you can pick your guest");
		ArrayList<Designation> designationList = designationService.getAllDesignations();
		for(Designation desig:designationList)
		{
			System.out.println("Designation ID = "+desig.getDesignationId()+ 
					"     Designation Name = "+desig.getDesignationName());
		}
		
		System.out.println("\n\n");
		while(want==1) {
			System.out.println("Enter Designation Id : ");
			int designationId=sc.nextInt();
			guestService.insertGuestList(designationId, eventId);
			System.out.println("Do you want to add more type of Guest\n If yes input 1\n "
					+ "If no press any other integer \n Enter your Choice :");
			want = sc.nextInt();
		}
		
		
		
		
	}
	
	//===================================================================================
	
	public void insertFood(int eventId) throws ClassNotFoundException, SQLException
	{
		System.out.println("Here is the list of all food from where you can pick your food item");
		ArrayList<FoodDatabase> foodList = foodDatabaseService.generateFoodList();
		int want=1;
		
		for(FoodDatabase food:foodList)
		{
			System.out.println("Food ID = "+food.getFoodId()+
					" Food Name = "+food.getFoodName()+" FoodPrice = "+food.getPrice());
		}
		while(want==1)
	    {
			System.out.println("\n\nEnter the food Id :");
			int foodId=sc.nextInt();
			FoodDatabase food = foodDatabaseService.getFoodById(foodId);
			//ArrayList<int> checkFood=foodServiceImp
			Food foodItem=input.acceptFoodListDetails(food,eventId);
			foodService.insertFood(foodItem);
			System.out.println("Do you want to add more food\n If yes input 1\n"
					+ " If no press any other integer\n Enter your Choice :");
			want = sc.nextInt();
			
		}
		
	}
	
	//=============================================================================================

	public void insertAttraction(int eventId) throws ClassNotFoundException, SQLException
	{
		int want=1;
		while(want==1)
		{
			Attraction attraction=input.acceptAttractionListDetails(eventId);
			attractionService.insertAttraction(attraction);
			System.out.println("Do you want to add more attraction\n If yes input 1\n"
					+ " If no press any other integer \n Enter your Choice :");
			want = sc.nextInt();
		}
		
	}
	
	//====================================================================================================
}
