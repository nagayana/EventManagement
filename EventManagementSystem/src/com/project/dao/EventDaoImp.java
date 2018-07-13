package com.project.dao;


import com.project.pojo.Event;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventDaoImp implements EventDao {

	@Override
<<<<<<< HEAD
	public Event searchEvent(int eventId){
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement pstmt = connection.prepareStatement("select * from Events where Event_Id =(?)");
		pstmt.setInt(1, eventId);
		ResultSet rs = pstmt.executeQuery();
		Event event = null;
		if(rs.next()==true) {
				event = new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5),rs.getInt(6),rs.getInt(7));
=======
	public Event searchEvent(int eventId) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
					"admin");
			pstmt = connection.prepareStatement("select* from Events where Event_Id =(?)");
			pstmt.setInt(1, event.getEventID());

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()==true)
		    {
		    	event.setEventID(rs.getInt(1));
		    	event.setEventName(rs.getString(2));
			    event.setEventLocation(rs.getString(3));
			    event.setEventTime(rs.getString(4));
			    event.setEventRegistrationDeadline(rs.getString(5));
			    event.setMaxRegistration(rs.getInt(6));
			    event.setCurrentRegistration(rs.getInt(7));
	
		    }
		    
		    return event;

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

>>>>>>> refs/remotes/origin/master
		}
		return event;
	}

	@Override
	public boolean insertEvent(Event event) {
<<<<<<< HEAD
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement pstmt = connection.prepareStatement("insert into Events values(?,?,?,?,?,?,?)");
		pstmt.setInt(1, event.getEventID());
		pstmt.setString(2, event.getEventName());
		pstmt.setString(3, event.getEventLocation());
		pstmt.setString(4, event.getEventTime());
		pstmt.setString(5, event.getEventRegistrationDeadline());
		pstmt.setInt(6, event.getMaxRegistration());
		pstmt.setInt(7, event.getCurrentRegistration());
		int result = pstmt.executeUpdate();
		
		if (result > 0){
				return true;
=======
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
					"admin");
			pstmt = connection.prepareStatement("insert into Events values(?,?,?,?,?,?,?)");
			pstmt.setInt(1, event.getEventID());
			pstmt.setString(2, event.getEventName());
			pstmt.setString(3, event.getEventLocation());
			pstmt.setString(4, event.getEventTime());
			pstmt.setString(5, event.getEventRegistrationDeadline());
			pstmt.setInt(6, event.getMaxRegistration());
			pstmt.setInt(7, event.getCurrentRegistration());
			int rows = pstmt.executeUpdate();

			if (rows > 0)
				System.out.println("Record Inserted");
			else
				System.out.println("Unable to Insert Record");

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

>>>>>>> refs/remotes/origin/master
		}
<<<<<<< HEAD
		else{
				return false;
		}
=======
		return false;
>>>>>>> refs/remotes/origin/master
	}

	@Override
	public boolean deleteEvent(int eventId) {

<<<<<<< HEAD
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement pstmt = connection.prepareStatement("delete from Events where Event_Id =(?)");
		pstmt.setInt(1, eventId);
		int result = pstmt.executeUpdate();
		if (result > 0){
				return true;
=======
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
					"admin");
			pstmt = connection.prepareStatement("delete from Events where Event_Id =(?)");
			pstmt.setInt(1, event.getEventID());

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

>>>>>>> refs/remotes/origin/master
		}
<<<<<<< HEAD
		else{
				return false;
		}
=======
		return false;

>>>>>>> refs/remotes/origin/master
	}
	
	@Override
	public boolean updateEventName(int eventId,String newName)
	{
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement pStatement = connection.prepareStatement("update events set event_name = ? where event_id = ?");
		pStatement.setString(1, newName);
		pStatement.setInt(2, eventId);
		int result = pStatement.executeUpdate();
		if(result>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public boolean updateEventLocation(int eventId,String newLocation)
	{
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement pStatement = connection.prepareStatement("update events set location = ? where event_id = ?");
		pStatement.setString(1, newLocation);
		pStatement.setInt(2, eventId);
		int result = pStatement.executeUpdate();
		if(result>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean updateEventTime(int eventId,String newTime)
	{
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement pStatement = connection.prepareStatement("update events set time = ? where event_id = ?");
		pStatement.setString(1, newTime);
		pStatement.setInt(2, eventId);
		int result = pStatement.executeUpdate();
		if(result>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean updateEventRegistrationDeadline(int eventId,String newDeadLine)
	{
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement pStatement = connection.prepareStatement("update events set registration_deadline = ? where event_id = ?");
		pStatement.setString(1, newDeadLine);
		pStatement.setInt(2, eventId);
		int result = pStatement.executeUpdate();
		if(result>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public boolean updateEvent(int eventId, Event newEvent) {
		 deleteEvent(eventId);
<<<<<<< HEAD
         insertEvent(newEvent);
         return true;
=======
         insertEvent(event);
		return false;
>>>>>>> refs/remotes/origin/master
	}

	@Override
	public ArrayList<Event> getAllEvents()
	{
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement pstmt = connection.prepareStatement("select * from Events");
		ArrayList<Event> events = new ArrayList<>();
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Event event = new Event(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getInt(6),rs.getInt(7));
			events.add(event);
		}
		return events;
	}
}