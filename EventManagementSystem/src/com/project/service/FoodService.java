package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.pojo.Food;

public interface FoodService {
	
	boolean insertFood(Food food) throws ClassNotFoundException, SQLException;
	ArrayList<Food> searchFoodList(int eventId) throws ClassNotFoundException, SQLException;
	int calulateFoodPrice(int price,int count);
	boolean deleteFood(int foodId,int eventId) throws ClassNotFoundException, SQLException;
	boolean updatefood(int foodId,int eventId,int quantity) throws ClassNotFoundException, SQLException;
	boolean deleteFoodByEventId(int eventId) throws ClassNotFoundException, SQLException;
	Food isFoodExist(int foodId,int eventId)throws ClassNotFoundException, SQLException;

}
