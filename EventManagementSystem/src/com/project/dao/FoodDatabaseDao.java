package com.project.dao;
import java.sql.SQLException;
import java.util.ArrayList;

import com.project.pojo.FoodDatabase;

public interface FoodDatabaseDao {
	ArrayList<FoodDatabase>  getFoodList() throws ClassNotFoundException, SQLException;
}
