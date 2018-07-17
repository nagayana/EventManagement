package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.dao.FoodDao;
import com.project.dao.FoodDaoimp;
import com.project.pojo.Food;

public class FoodServiceImp implements FoodService {

	@Override
	public boolean insertFood(Food food) throws ClassNotFoundException, SQLException {
		FoodDaoimp foodObj=new FoodDaoimp();
		return foodObj.insertFood(food);
		
	}

	

	@Override
	public int calulateFoodPrice(int price, int count) {
		return price*count;
	}



	@Override
	public ArrayList<Food> searchFoodList(int eventId) throws ClassNotFoundException, SQLException {
		FoodDaoimp foodObj=new FoodDaoimp();
		ArrayList<Food> foodList=foodObj.getFoodList(eventId);
		return foodList;
	}



	@Override
	public boolean deleteFood(String foodName, int eventId) throws ClassNotFoundException, SQLException {
		FoodDaoimp foodObj=new FoodDaoimp();
		return foodObj.deleteFood(foodName,eventId);
	}



	@Override
	public boolean updatefood(String foodName, int eventId,int quantity) throws ClassNotFoundException, SQLException {
		FoodDaoimp foodObj=new FoodDaoimp();
		return foodObj.updateFood(foodName,eventId,quantity);
	}



	@Override
	public boolean deleteFoodByEventId(int eventId) throws ClassNotFoundException, SQLException {
		FoodDaoimp foodObj=new FoodDaoimp();
		return foodObj.deleteFoodByEventId(eventId);
	}

		
	

}
