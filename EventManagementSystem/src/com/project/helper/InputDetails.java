package com.project.helper;

import java.sql.SQLException;
import java.util.Scanner;

import com.project.pojo.Attraction;
import com.project.pojo.Event;
import com.project.pojo.Food;
import com.project.pojo.GuestList;
import com.project.service.*;

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

	public static Food acceptFoodListDetails() {
		Scanner sc = new Scanner(System.in);
	    Food foodList=new Food();
	    System.out.println("enter the food ID ");
	    foodList.setFoodId(sc.nextInt());
	    System.out.println("enter the food name ");
	    foodList.setFoodName(sc.next());
	    String foodname=  foodList.getFoodName();
	    FoodDatabseService foodprice=new FoodDatabaseServiceImp();
	    try {
			foodprice.getFoodListbyPrice(foodname);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("enter the quatity you want");
	    foodList.setQuantity(sc.nextInt());
	    System.out.println("for which event you want to enter?");
        int eventno=sc.nextInt();
        foodList.setEventId(eventno);
		return foodList;
	}

	public static Attraction acceptAttractionListDetails() {
		Scanner sc = new Scanner(System.in);
		Attraction attraction=new Attraction();
		System.out.println("eneter event id for attraction");
		attraction.setEventId(sc.nextInt());
		System.out.println("enter attraction id");
		attraction.setAttractionId(sc.nextInt());
		System.out.println("enter attraction name");
		attraction.setName(sc.next());
		System.out.println("enter attraction co-ordinator");
		attraction.setCoordinatorName(sc.next());
		System.out.println("enter attraction duration");
		attraction.setDuration(sc.nextInt());
		System.out.println("enter attraction price");
		if(attraction.getName().equalsIgnoreCase("Food"))
		{ // calculate the price of food abhimanyu!!!	
		}
		else {
			attraction.setPrice(sc.nextInt());
		}
		return attraction;
	}

}
