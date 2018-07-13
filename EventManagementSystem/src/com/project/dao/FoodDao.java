 package com.project.dao;
import com.project.pojo.Food;

public interface FoodDao {
	Food getFoodList(String foodName);

	boolean insertFood(Food food);

	boolean deleteFood(String foodName);

	boolean updateFood(String foodName);

	


}
