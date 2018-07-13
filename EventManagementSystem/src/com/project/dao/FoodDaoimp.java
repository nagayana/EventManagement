 package com.project.dao;
import com.project.pojo.Food;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FoodDaoimp implements FoodDao{
	Food food=null;

	@Override
	public Food getFoodList(String foodName) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ArrayList<Food> result = new ArrayList<Food>();
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
					"kanishka");
			pstmt = connection.prepareStatement("select* from food where Food_Id =(?)");
			pstmt.setInt(1,food.getFoodId());

			ResultSet rs = pstmt.executeQuery();
			

			while(rs.next()==true)
		    {    food= new Food(rs.getInt(1),
		    		rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));
		    	food.setFoodId(rs.getInt(1));
		    	food.setFoodName(rs.getString(2));
			    food.setPrice(rs.getInt(3));
			    food.setQuantity(rs.getInt(4));
			    food.setEventId(rs.getInt(5));
	
		    }
		    
		    return food;

		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// 5.close the connection
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return food;

	
	}

	@Override
	public boolean insertFood(String foodName) {
		Connection connection=null; 
		PreparedStatement pstmt=null;
		try {
			Class.forName("org.postgresql.Driver");
			connection=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "kanishka");
			pstmt=connection.prepareStatement("insert into food values(?,?,?,?,?)");
			pstmt.setInt(1,food.getFoodId());
			pstmt.setString(2,food.getFoodName());
			pstmt.setInt(3,food.getPrice());
			pstmt.setInt(4,food.getQuantity());
			pstmt.setInt(5,food.getEventId() );
			int rows=pstmt.executeUpdate();
			
		
		if(rows>0)
			System.out.println("Record Inserted");
		else
			System.out.println("Unable to Insert Record");
		
		}
		catch(ClassNotFoundException exception){
			exception.printStackTrace();
		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			//5.close the connection
			try {
				connection.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		
		
	}
		return true;
	}

	@Override
	public boolean deleteFood(String foodName) {
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
					"kanishka");
			pstmt = connection.prepareStatement("delete from Events where id=(?)");
			pstmt.setInt(1,food.getFoodId());

			int rows = pstmt.executeUpdate();

			if (rows > 0)
				System.out.println("Record deleted");
			else
				System.out.println("Unable to delete Record");

		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// 5.close the connection
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return true;
	}

	@Override
	public boolean updateFood(String foodName) {
		deleteFood(foodName);
        insertFood(foodName);
	   return true;
	}

}
