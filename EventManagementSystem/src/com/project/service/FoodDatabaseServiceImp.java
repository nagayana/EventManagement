package com.project.service;

import java.util.ArrayList;

import com.project.dao.FoodDatabaseDao;
import com.project.dao.FoodDatabaseImp;
import com.project.pojo.FoodDatabase;

public class FoodDatabaseServiceImp {
	ArrayList<FoodDatabase> generateFoodList() {
		FoodDatabaseDao foodDB = new FoodDatabaseImp();
		return foodDB.getFoodList();

	}

}
