package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.pojo.Attraction;

public class AttractionDaoImplement implements AttractionDaoInterface {
	private Connection con=null;
	private PreparedStatement psmt=null;
	private Statement smt=null;

	public boolean insertAttraction(Attraction attraction) throws SQLException, ClassNotFoundException {
		
		
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://127."
					+ "0.0.1:5432/eventmanagement", "postgres", "admin");
			
		    int id=attraction.getAttractionId();
		    String coordinatorName=attraction.getCoordinatorName();
		    String name=attraction.getName();
		    int duration=attraction.getDuration();
		    int price=attraction.getPrice();
		    int eventId=attraction.getEventId();
		    
		    psmt=con.prepareStatement("insert into attraction values(?,?,?,?,?,?)");
		    psmt.setInt(1, id);
		    psmt.setString(2, name);
		    psmt.setString(3, coordinatorName);
		    psmt.setInt(4, duration);
		    psmt.setInt(5, price);
		    psmt.setInt(6, eventId);
		    
		    int rows=psmt.executeUpdate();
		    if(rows>0)
			  return true;
			else
				return false;
	}

	
	public boolean deleteAttraction(int attractionId)throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eventmanagement",
				"postgres", "admin");
		smt=con.createStatement();
		String s="delete from attraction where attraction_id="+attractionId;
		int check=smt.executeUpdate(s);
	    if(check>0)
	    	return true;
	    else
	    	return false;
	}


	public boolean updateAttraction(int attractionId, Attraction attraction)throws SQLException, ClassNotFoundException {
         deleteAttraction(attractionId);
         insertAttraction(attraction);
         return false;
	} 


	public List<Attraction> searchAttraction(int eventId) throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eventmanagementsystem",
				"postgres", "admin");
		smt=con.createStatement();
		ResultSet rs=smt.executeQuery("select * from attraction where event_id="+eventId);
		List<Attraction> attractionList=new ArrayList<>();
	    Attraction obj=new Attraction();
	    if(rs.next()==true)
	    {
	    	obj.setAttractionId(rs.getInt(1));
		    obj.setName(rs.getString(2));
		    obj.setCoordinatorName(rs.getString(3));
		    obj.setDuration(rs.getInt(4));
		    obj.setPrice(rs.getInt(5));
		    obj.setEventId(rs.getInt(6));
		    attractionList.add(obj);
	    }
	    
	    return attractionList;
	    
	    
	}


	@Override
	public Attraction getAttractionById(int attractionId) throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eventmanagementsystem",
				"postgres", "admin");
		smt=con.createStatement();
		ResultSet rs=smt.executeQuery("select * from attraction where attraction_id="+attractionId);
	    Attraction obj=new Attraction();
	    if(rs.next()==true)
	    {
	    	obj.setAttractionId(rs.getInt(1));
		    obj.setName(rs.getString(2));
		    obj.setCoordinatorName(rs.getString(3));
		    obj.setDuration(rs.getInt(4));
		    obj.setPrice(rs.getInt(5));
		    obj.setEventId(rs.getInt(6));
	    }
	    
	    return obj;
	}

}
