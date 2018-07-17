package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.pojo.Food;

public interface FoodService {
	
	boolean insertFood(Food food) throws ClassNotFoundException, SQLException;
	ArrayList<Food> searchFoodList(int eventId) throws ClassNotFoundException, SQLException;
	int calulateFoodPrice(int price,int count);
	boolean deleteFood(String foodName,int eventId) throws ClassNotFoundException, SQLException;
	boolean updatefood(String foodName,int eventId,int quantity) throws ClassNotFoundException, SQLException;
	boolean deleteFoodByEventId(int eventId) throws ClassNotFoundException, SQLException;

}
