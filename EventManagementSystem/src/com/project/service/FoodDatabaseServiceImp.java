package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.project.dao.FoodDatabaseDao;
import com.project.dao.FoodDatabaseImp;
import com.project.pojo.FoodDatabase;

public class FoodDatabaseServiceImp {
	public ArrayList<FoodDatabase> generateFoodList() throws ClassNotFoundException, SQLException {
		FoodDatabaseDao foodDB = new FoodDatabaseImp();
		return foodDB.getFoodList();

	}

}
