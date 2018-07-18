package com.project.helper;

import java.sql.SQLException;

public interface UpdateEventHelper {
	
	public boolean showGuest(int eventId);
	public void deleteGuest(int eventId,int designationId) throws ClassNotFoundException, SQLException;
	public void insertNewGuest(int eventId,int designationId) throws ClassNotFoundException, SQLException;
	
	public boolean showFood(int eventId);
	public void deleteFood(int foodId,int eventId) throws ClassNotFoundException, SQLException;
	public void insertFood(int eventId) throws ClassNotFoundException, SQLException;
	public void updateFoodQuantity(int foodId,int eventId,int quantity) throws ClassNotFoundException, SQLException;
	
	public void insertAttraction(int eventId) throws ClassNotFoundException, SQLException;
	public void deleteAttraction(int eventId,int attractionId) throws ClassNotFoundException, SQLException;
	public boolean showAttraction(int eventId);

}
