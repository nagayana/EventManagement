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
	IntegerValidation intvalidation=new IntegerValidation();
	Timestamp t;
	public Event acceptEventDetails(){
		Scanner sc = new Scanner(System.in);
		Event event=new Event();
		System.out.print("Enter Event ID :");
		event.setEventID(intvalidation.validatInteger());
		System.out.print("Enter Event Name :");
		event.setEventName(sc.next());
		System.out.print("Enter Event location :"); 
		event.setEventLocation(sc.next());
		System.out.print("Enter Event time (yyyy-mm-ddthh:mm:ss):");
		LocalDateTime eventTime = LocalDateTime.parse(sc.next());
		while(LocalDateTime.now().isAfter(eventTime)){
			System.out.println("Please Select a coming Date ");
			System.out.print("Again Enter Event Time(yyyy-mm-ddthh:mm:ss):");
			eventTime = LocalDateTime.parse(sc.next());
		}
		event.setEventTime(eventTime);
		System.out.print("Enter Event Registration deadline (yyyy-mm-ddthh:mm:ss):"); 
		
		LocalDateTime eventDeadline = LocalDateTime.parse(sc.next());
		while(LocalDateTime.now().isAfter(eventDeadline)){
			System.out.println("Please select a coming Date");
			System.out.print("Enter event Registration deadline (yyyy-mm-ddthh:mm:ss):");
			eventDeadline = LocalDateTime.parse(sc.next());
		}
		
		while(eventDeadline.isAfter(eventTime)){
			System.out.println("Deadline date must be before event date. Please try again");
			System.out.print("Enter event Registration deadline :");
			eventDeadline = LocalDateTime.parse(sc.next());
		}
		
		event.setEventRegistrationDeadline(eventDeadline);
		System.out.print("Enter event maximum registration value :"); 
		event.setMaxRegistration(intvalidation.validatInteger());
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
	    foodList.setQuantity(intvalidation.validatInteger());
		return foodList;
	}


	public Attraction acceptAttractionListDetails(int eventId) {
		Scanner sc = new Scanner(System.in);
		Attraction attraction=new Attraction();
		attraction.setEventId(eventId);
		System.out.println("Enter attraction id :");
		attraction.setAttractionId(intvalidation.validatInteger());
		System.out.println("Enter attraction name :");
		attraction.setName(sc.next());
		System.out.println("Enter attraction co-ordinator");
		attraction.setCoordinatorName(sc.next());
		System.out.println("Enter attraction duration in Hours :");
		attraction.setDuration(intvalidation.validatInteger());
		System.out.println("Enter attraction price :");
		attraction.setPrice(intvalidation.validatInteger());
		
		return attraction;
	}

}
