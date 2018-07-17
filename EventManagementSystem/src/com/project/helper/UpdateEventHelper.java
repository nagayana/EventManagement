package com.project.helper;

import java.sql.SQLException;

public interface UpdateEventHelper {
	
	public void showGuest(int eventId);
	public void deleteGuest(int eventId,int designationId) throws ClassNotFoundException, SQLException;
	public void insertNewGuest(int eventId,int designationId) throws ClassNotFoundException, SQLException;
	
	public void showFood(int eventId);
	public void deleteFood(String foodName,int eventId) throws ClassNotFoundException, SQLException;
	public void insertFood(int eventId) throws ClassNotFoundException, SQLException;
	public void updateFoodQuantity(String foodName,int eventId,int quantity) throws ClassNotFoundException, SQLException;
	
	public void insertAttraction(int eventId) throws ClassNotFoundException, SQLException;
	public void deleteAttraction(int eventId,int attractionId) throws ClassNotFoundException, SQLException;
	public void showAttraction(int eventId);

}
