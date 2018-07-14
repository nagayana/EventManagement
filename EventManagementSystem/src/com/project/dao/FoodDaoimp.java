 package com.project.dao;
import com.project.pojo.Food;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoimp implements FoodDao{

	@Override
	public List<Food> getFoodList(int eventId) throws ClassNotFoundException, SQLException {
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from food where event_id=?");
		preparedStatement.setInt(1, eventId);
		ResultSet rs = preparedStatement.executeQuery();
			
		List<Food> foodList=new ArrayList<>();
		while(rs.next()){    
			Food food= new Food(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
			    foodList.add(food);
		    }
		    return foodList;
	}

	@Override
	public boolean insertFood(Food food) throws SQLException, ClassNotFoundException {
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("insert into food values(?,?,?,?,?)");
		
		pstmt.setInt(1,food.getFoodId());
		pstmt.setString(2,food.getFoodName());
		pstmt.setInt(3,food.getPrice());
		pstmt.setInt(4,food.getQuantity());
		pstmt.setInt(5,food.getEventId() );
		int result = pstmt.executeUpdate();
		if(result>0){
			return true;
		}
		else{
			return false;
		}
	}
			
	@Override
	public boolean deleteFood(String foodName,int eventId) throws ClassNotFoundException, SQLException {
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pStatement = connection.prepareStatement("delete from food where food_name = ? and event_id = ?");
		pStatement.setString(1,foodName);
		pStatement.setInt(2, eventId);
		int result = pStatement.executeUpdate();
		if (result> 0){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean updateFood(String foodName, int eventId,int quantity) throws ClassNotFoundException, SQLException {
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pStatement = connection.prepareStatement("update food set quantity = ? where food_name = ? "
				+ "and event_id = ?");
		pStatement.setInt(1, quantity);
		pStatement.setString(2, foodName);
		pStatement.setInt(3, eventId);
		int result = pStatement.executeUpdate();
		if (result> 0){
			return true;
		}
		else{
			return false;
		}
	}
}

	






