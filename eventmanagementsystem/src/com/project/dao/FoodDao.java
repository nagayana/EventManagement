 package com.project.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.pojo.Food;

public interface FoodDao {

	ArrayList<Food> getFoodList(int eventId) throws ClassNotFoundException, SQLException;
    boolean insertFood(Food food) throws ClassNotFoundException, SQLException;
    boolean deleteFood(int foodId,int eventId) throws ClassNotFoundException, SQLException;
    boolean updateFood(int foodId, int eventId,int quantity) throws ClassNotFoundException, SQLException;
    boolean deleteFoodByEventId(int eventId) throws SQLException, ClassNotFoundException;
    Food isFoodExist(int foodId,int eventId)throws ClassNotFoundException, SQLException;
}
