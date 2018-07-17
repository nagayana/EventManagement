package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.pojo.Attraction;

public class AttractionDaoImplement implements AttractionDaoInterface {

	public boolean insertAttraction(Attraction attraction) throws SQLException, ClassNotFoundException {
			Connection con = DBConnection.getDBConnection();
			PreparedStatement psmt = con.prepareStatement("insert into attraction values(?,?,?,?,?,?)");
		    
			int id=attraction.getAttractionId();
		    int duration=attraction.getDuration();
		    int price=attraction.getPrice();
		    int eventId=attraction.getEventId();
		    String coordinatorName=attraction.getCoordinatorName();
		    String name=attraction.getName();
		    
		    psmt.setInt(1, id);
		    psmt.setString(2, name);
		    psmt.setString(3, coordinatorName);
		    psmt.setInt(4, duration);
		    psmt.setInt(5, price);
		    psmt.setInt(6, eventId);
		    
		    int rows=psmt.executeUpdate();
		    if(rows>0){
			  return true;
		    }
			else{
				return false; 
			}
	}
	
	public boolean deleteAttraction(int attractionId)throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getDBConnection();
		PreparedStatement preparedStatement = con.prepareStatement("delete from attraction where attraction_id = ?");
		preparedStatement.setInt(1, attractionId);
		
		int result = preparedStatement.executeUpdate();
	    if(result>0){
	    	return true;
	    }
	    else{
	    	return false; 
	    }
	}

	public boolean updateAttraction(int attractionId, Attraction attraction)throws SQLException, ClassNotFoundException {
         deleteAttraction(attractionId);
         return insertAttraction(attraction);
	} 

	@Override
	public ArrayList<Attraction> getEventAttractions(int eventId) throws SQLException, ClassNotFoundException{
		ArrayList<Attraction> attractionList=new ArrayList<>();
		
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from attraction where event_id = ?");
		preparedStatement.setInt(1, eventId);
		ResultSet rs = preparedStatement.executeQuery();
		
	    while(rs.next())
	    {
	    	Attraction attraction = new Attraction(rs.getInt(1), rs.getString(2), rs.getString(3), 
	    			rs.getInt(4), rs.getInt(5), rs.getInt(6));getClass();
	    	attractionList.add(attraction);
	    }
	    return attractionList;
	}

	@Override
	public Attraction getAttractionById(int attractionId) throws SQLException, ClassNotFoundException {
		Connection con = DBConnection.getDBConnection();
		PreparedStatement preparedStatement = con.prepareStatement("select * from attraction where attraction_id = ?");
		preparedStatement.setInt(1, attractionId);
		ResultSet rs = preparedStatement.executeQuery();
	    Attraction attraction = null;
	    if(rs.next()==true)
	    {
	    	attraction = new Attraction(rs.getInt(1), rs.getString(2), rs.getString(3), 
	    			rs.getInt(4), rs.getInt(5), rs.getInt(6));getClass();
	    }
	    return attraction;
	}

	@Override
	public boolean deleteAttractionByEvenetId(int eventId) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.getDBConnection();
		PreparedStatement preparedStatement = con.prepareStatement("delete from attraction where event_id = ?");
		preparedStatement.setInt(1, eventId);
		
		int result = preparedStatement.executeUpdate();
	    if(result>0){
	    	return true;
	    }
	    else{
	    	return false;
	    }
	}

}
