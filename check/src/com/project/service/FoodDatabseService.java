package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.project.pojo.FoodDatabase;


public interface FoodDatabseService {
	ArrayList<FoodDatabase> generateFoodList() throws ClassNotFoundException, SQLException;
	int getFoodListbyPrice(String foodName) throws ClassNotFoundException, SQLException;

	FoodDatabase getFoodById(int foodId) throws ClassNotFoundException, SQLException;


}
