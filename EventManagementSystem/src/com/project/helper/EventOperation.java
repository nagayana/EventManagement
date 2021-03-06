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
		foodService.deleteFoodByEventId(eventId);
		guestService.deleteGuestListByEventId(eventId);
		attractionService.deleteAttractionByEvenetId(eventId);
		if(eventService.deleteEvent(eventId))
			return true; 
		else 
			return false;
		
			
	}
	
	//===================================================================================
	
	public void insertGuest(int eventId) throws ClassNotFoundException, SQLException
	{
		int want=1; 
		System.out.println("-----------------------------------------------------------------------------\n"
				+ "Here is the list of Designation from where you can pick your guest");
		ArrayList<Designation> designationList = designationService.getAllDesignations(eventId);
		for(Designation desig:designationList)
		{
			System.out.println("Designation ID = "+desig.getDesignationId()+ 
					"     Designation Name = "+desig.getDesignationName());
		}
		
		System.out.println("\n");
		while(want==1) {
			ArrayList<Integer> validDesignationList=guestService.DesignationByEventId(eventId);
			System.out.println("Enter Designation Id : ");
			IntegerValidation intvalidation=new IntegerValidation();
			int designationId=intvalidation.validatInteger();
			while(validDesignationList.contains(designationId))
					{
				           System.out.println("The event either contain the input Id or the Input Id is not a valid designation ID"
				           		+ "\nPlease enter a new one :");
				           designationId=intvalidation.validatInteger();
					}
			guestService.insertGuestList(designationId, eventId);
			System.out.println("--------------------------------------------------------------------------------\n"
					+ "Do you want to add more type of Guest\nIf yes input 1\n "
					+ "If no press any other integer \nEnter your Choice :");
			want = sc.nextInt();
		}
		
		
		
		
	}
	
	//===================================================================================
	
	public void insertFood(int eventId) throws ClassNotFoundException, SQLException
	{
		System.out.println("-------------------------------------------------------------------------------------\n"
				+ "Here is the list of all food from where you can pick your food item");
		ArrayList<FoodDatabase> foodList = foodDatabaseService.generateFoodList();
		int want=1;
		
		for(FoodDatabase food:foodList) 
		{
			System.out.println("Food ID = "+food.getFoodId()+
					"    Food Name = "+food.getFoodName()+"     FoodPrice ="+food.getPrice());
		}
		while(want==1)
	    {
			System.out.println("\n\nEnter the food Id :");
			int foodId=sc.nextInt();
			Food foodobj=foodService.isFoodExist(foodId, eventId);
			if(foodobj != null)
			{ 
				IntegerValidation intValidation=new IntegerValidation();
				System.out.println("This food is already in the list \nEnter the additional amount :");
				foodService.updatefood(foodId, eventId, foodobj.getQuantity()+intValidation.validatInteger());
			}
			else
			{
				FoodDatabase food = foodDatabaseService.getFoodById(foodId);
				Food foodItem=input.acceptFoodListDetails(food,eventId);
				foodService.insertFood(foodItem);
			}
			
			System.out.println("----------------------------------------------------------------------------------------\n"
					+ "Do you want to add more food\nIf yes input 1\n"
					+ "If no press any other integer\nEnter your Choice :");
			want = sc.nextInt();
			
		}
		
	}
	
	//=============================================================================================

	public void insertAttraction(int eventId) throws ClassNotFoundException, SQLException
	{
		int want=1;
		while(want==1)
		{ 
			System.out.println("------------------------------------------------------------------------------------------------");
			Attraction attraction=input.acceptAttractionListDetails(eventId);
			attractionService.insertAttraction(attraction);
			System.out.println("----------------------------------------------------------------------------------------\n"
					+ "Do you want to add more attraction\nIf yes input 1\n"
					+ "If no press any other integer \nEnter your Choice :");
			want = sc.nextInt();
		}
		
	}
	
	//====================================================================================================
}
