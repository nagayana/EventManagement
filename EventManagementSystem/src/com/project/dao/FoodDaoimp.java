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
	Food food=null;

	@Override
	public List<Food> getFoodList(int eventId) throws ClassNotFoundException, SQLException {
		
		Connection connection = null;
		Statement smt= null;
		List<Food> foodList=new ArrayList<>();
		
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eventmanagement", "postgres", "admin");
			smt=connection.createStatement();
			String s="select * from food where eventId="+eventId;
			ResultSet rs=smt.executeQuery(s);
			

			while(rs.next()==true)
		    {    food= new Food(rs.getInt(1),
		    		rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
		    	food.setFoodId(rs.getInt(1));
		    	food.setFoodName(rs.getString(2));
			    food.setPrice(rs.getInt(3));
			    food.setQuantity(rs.getInt(4));
			    food.setEventId(rs.getInt(5));
			    foodList.add(food);
	
		    }
		    
		    return foodList;

		

	
	}

	@Override

	public boolean insertFood(Food food) throws SQLException, ClassNotFoundException {
		Connection connection=null; 
		PreparedStatement pstmt=null;
		
			Class.forName("org.postgresql.Driver");

			connection=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eventmanagement", "postgres", "admin");
			pstmt=connection.prepareStatement("insert into food values(?,?,?,?,?)");
			pstmt.setInt(1,food.getFoodId());
			pstmt.setString(2,food.getFoodName());
			pstmt.setInt(3,food.getPrice());
			pstmt.setInt(4,food.getQuantity());
			pstmt.setInt(5,food.getEventId() );
			int rows=pstmt.executeUpdate();
			if(rows>0)
				return true;
			else
				return false;
	}
			
		
		
		


	@Override
	public boolean deleteFood(String foodName,int eventId) throws ClassNotFoundException, SQLException {
		
		Connection connection = null;
		
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eventmanagement", "postgres", "admin");
			Statement smt=connection.createStatement();
			String s="delete from food where food_name="+foodName+"and event_id="+eventId;
			int check=smt.executeUpdate(s);

			if (check> 0)
				return true;
			else
				return false;


	}


	
	public boolean updateFood(String foodName, int eventId,int quantity) throws ClassNotFoundException, SQLException {
		Connection connection = null;
		
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eventmanagement", "postgres", "admin");
			Statement smt=connection.createStatement();
			String s="update food set quantity="+quantity+" where food_name="+foodName+" event_id="+eventId;
			int check=smt.executeUpdate(s);

			if (check> 0)
				return true;
			else
				return false;
         }
}

	






