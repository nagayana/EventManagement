
package com.project.helper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.project.pojo.Attraction;
import com.project.pojo.Food;
import com.project.pojo.GuestList;
import com.project.service.AttractionServiceImp;
import com.project.service.FoodServiceImp;
import com.project.service.GuestListServiceImp;

public class UpdateEventHelperImp implements UpdateEventHelper {
	
	GuestListServiceImp gs=new GuestListServiceImp();
	FoodServiceImp fs=new FoodServiceImp();
	EventOperation eventOp=new EventOperation();
	AttractionServiceImp as=new AttractionServiceImp();
	
	
	@Override
	public boolean showGuest(int eventId) {
		 ArrayList<GuestList> guest=new ArrayList<>();
		 try {
			   guest=gs.generateGuestList(eventId);
	    } catch (ClassNotFoundException | SQLException e) { 
		       e.printStackTrace(); 
	    }
		 if(guest.isEmpty())
			 return false;
		 else
		 {
			 System.out.println("\n\nHere are the Guest list for event ID :"+eventId);
			    for(GuestList gl:guest)
			    {
			    	System.out.println(gl.getDesignationId());
			    }
			    return true;
		 }
		 
		 
	}

	@Override
	public void deleteGuest(int eventId, int designationId) throws ClassNotFoundException, SQLException {
		gs.deleteGuestList(designationId, eventId);
		
	}

	@Override
	public void insertNewGuest(int eventId, int designationId) throws ClassNotFoundException, SQLException {
		gs.insertGuestList(designationId, eventId);
	}

	@Override
	public boolean showFood(int eventId) {
		    ArrayList<Food> food=new ArrayList<>();
		    try {
				  food=fs.searchFoodList(eventId);
		    } catch (ClassNotFoundException | SQLException e) {
			       e.printStackTrace();
		    }
		    if(food.isEmpty())
		    	return false;
		    else
		    {
		    	System.out.println("\n\nHere are the Food list for event ID :"+eventId);
			    for(Food fl:food)
			    {
			    	System.out.println("Food Name = "+fl.getFoodName()+
			    			"    Food Price = "+fl.getPrice()+"    Food Quantity = "+fl.getQuantity());
			    }
			    return true;
		    }
		    
		    
		    
		 
	}

	@Override
	public void deleteFood(int foodId, int eventId) throws ClassNotFoundException, SQLException {
		fs.deleteFood(foodId, eventId);
		
	}

	@Override
	public void insertFood(int eventId) throws ClassNotFoundException, SQLException {
		eventOp.insertFood(eventId);
		
	}

	@Override
	public void updateFoodQuantity(int foodId, int eventId, int quantity) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter new quantity of the food : ");
		fs.updatefood(foodId, eventId,sc.nextInt() );
		
	}

	@Override
	public void insertAttraction(int eventId) throws ClassNotFoundException, SQLException {
		eventOp.insertAttraction(eventId);
		
	}

	@Override
	public void deleteAttraction(int eventId, int attractionId) throws ClassNotFoundException, SQLException {
		as.deleteAttraction(attractionId);
		
	}

	@Override
	public boolean showAttraction(int eventId) {
		 ArrayList<Attraction> attraction=new ArrayList<>();
		 try {
	    	   attraction = as.getAttractionList(eventId);
	    } catch (ClassNotFoundException | SQLException e) {
		       e.printStackTrace();
	    }
		 if(attraction.isEmpty())
			 return false;
		 else
		 {
			 System.out.println("\n\nHere are the attraction list for event ID :"+eventId);
			    for(Attraction at:attraction)
			    {
			    	System.out.println("Attraction Name = "+at.getCoordinatorName()+"    Attraction Id = "+at.getAttractionId());
			    }
			    return true;
		 }
		
	}
	
	

}
