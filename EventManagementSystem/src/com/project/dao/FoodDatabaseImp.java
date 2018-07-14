package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.project.pojo.FoodDatabase;

public class FoodDatabaseImp implements FoodDatabaseDao{
	
	@Override
	public ArrayList<FoodDatabase> getFoodList() throws SQLException,ClassNotFoundException{
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pStatement = connection.prepareStatement("select * from fooddatabase");
		ResultSet rs = pStatement.executeQuery();
		ArrayList<FoodDatabase> foodList = new ArrayList<>();
		while(rs.next()){
			FoodDatabase fDatabase = new FoodDatabase(rs.getInt(1), rs.getString(2), rs.getInt(3));
			foodList.add(fDatabase);
		}
		return foodList;
	}
}
