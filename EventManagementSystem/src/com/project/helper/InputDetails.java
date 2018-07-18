package com.project.helper;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import com.project.pojo.Attraction;
import com.project.pojo.Event;
import com.project.pojo.Food;
import com.project.pojo.FoodDatabase;
import com.project.pojo.GuestList;
import com.project.service.*;

public class InputDetails {
	
	Timestamp t;
	public Event acceptEventDetails(){
		Scanner sc = new Scanner(System.in);
		Event event=new Event();
		System.out.println("Enter event ID (INTEGER):");
		event.setEventID(sc.nextInt());
		System.out.println("Enter event Name :");
		event.setEventName(sc.next());
		System.out.println("Enter event location :");
		event.setEventLocation(sc.next());
		System.out.println("Enter event time :");
		LocalDateTime eventTime = LocalDateTime.parse(sc.next());
	
		event.setEventTime(eventTime);
		System.out.println("Enter event Registration deadline :");
		
		LocalDateTime eventDeadline = LocalDateTime.parse(sc.next());
		
		while(eventDeadline.isAfter(eventTime)){
			Scanner scanner = new Scanner(System.in);
			System.out.println("Deadline date must be before event date. Please try again");
			System.out.print("Enter event Registration deadline :");
			eventDeadline = LocalDateTime.parse(scanner.next());
		}
		
		event.setEventRegistrationDeadline(eventDeadline);
		System.out.println("Enter event maximum registration value :"); 
		event.setMaxRegistration(sc.nextInt());
		event.setCurrentRegistration(0); 
		return event;
		
		
		 
		
	}

	public Food acceptFoodListDetails(FoodDatabase foodData, int eventId) {
		Scanner sc = new Scanner(System.in);
	    Food foodList=new Food();
	    foodList.setFoodId(foodData.getFoodId());
	    foodList.setFoodName(foodData.getFoodName());
	    foodList.setPrice((int)foodData.getPrice());
	    foodList.setEventId(eventId);
	    
	    System.out.println("Enter the quatity you "
	    		+ "want :");
	    foodList.setQuantity(sc.nextInt());
		return foodList;
	}


	public Attraction acceptAttractionListDetails(int eventId) {
		Scanner sc = new Scanner(System.in);
		Attraction attraction=new Attraction();
		attraction.setEventId(eventId);
		System.out.println("Enter attraction id :");
		attraction.setAttractionId(sc.nextInt());
		System.out.println("Enter attraction name :");
		attraction.setName(sc.next());
		System.out.println("Enter attraction co-ordinator");
		attraction.setCoordinatorName(sc.next());
		System.out.println("Enter attraction duration in Hours :");
		attraction.setDuration(sc.nextInt());
		System.out.println("Enter attraction price :");
		attraction.setPrice(sc.nextInt());
		
		return attraction;
	}

}
