 package com.project.dao;
import com.project.pojo.Food;

public interface FoodDao {
	Food getFoodList(String foodName);

	boolean insertFood(String foodName);

	boolean deleteFood(String foodName);

	boolean updateFood(String foodName);


}
