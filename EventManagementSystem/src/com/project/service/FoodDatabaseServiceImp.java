package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.project.dao.FoodDatabaseDao;
import com.project.dao.FoodDatabaseImp;
import com.project.pojo.FoodDatabase;

public class FoodDatabaseServiceImp implements FoodDatabseService{
	public ArrayList<FoodDatabase> generateFoodList() throws ClassNotFoundException, SQLException {
		FoodDatabaseDao foodDB = new FoodDatabaseImp();
		return foodDB.getFoodList();

	}
	
	@Override
	public int getFoodListbyPrice(String foodName) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		FoodDatabaseDao foodDB = new FoodDatabaseImp();
		return foodDB.getFoodListbyPrice(foodName);
		
	}
	
}
