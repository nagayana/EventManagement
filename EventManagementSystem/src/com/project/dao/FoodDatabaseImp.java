package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.project.pojo.FoodDatabase;

public class FoodDatabaseImp implements FoodDatabaseDao{
	
	@Override
	public ArrayList<FoodDatabase> getFoodList(){
		ArrayList<FoodDatabase> foods = new ArrayList<>();
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement pStatement = connection.prepareStatement("select * from fooddatabase");
		
		ResultSet rs = pStatement.executeQuery();
		while(rs.next()){
			FoodDatabase fDatabase = new FoodDatabase(rs.getInt(1), rs.getString(2), rs.getInt(3));
			foods.add(fDatabase);
		}
		return foods;
	}
}
