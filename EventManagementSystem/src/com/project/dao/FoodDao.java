 package com.project.dao;
import java.sql.SQLException;
import java.util.List;

import com.project.pojo.Food;

public interface FoodDao {
	List<Food> getFoodList(int eventId) throws ClassNotFoundException, SQLException;

	boolean insertFood(Food food) throws ClassNotFoundException, SQLException;

	boolean deleteFood(String foodName,int eventId) throws ClassNotFoundException, SQLException;

	boolean updateFood(String foodName, int eventId,int quantity) throws ClassNotFoundException, SQLException;


}
