package com.project.dao;


import com.project.pojo.Event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class EventDaoImp implements EventDao {

	@Override
	public Event getEvent(int eventId) throws ClassNotFoundException, SQLException {
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("select * from events where event_id = ?");
		pstmt.setInt(1, eventId); 
		ResultSet rs = pstmt.executeQuery();
		Event event = null;
		if(rs.next()) {
				event = new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
						rs.getInt(5),LocalDateTime.parse(rs.getString(6)),LocalDateTime.parse(rs.getString(7)));
		}
		return event;
	}
	
	@Override
	public ArrayList<Event> getUnregisteredEventsByEmployeeId(int employeeId) throws SQLException,ClassNotFoundException
	{
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("select * from events where event_id not in "
				+ "(select event_id from registrations where employee_id = ?)");
		pstmt.setInt(1, employeeId);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Event> unRegisteredEvents = new ArrayList<>();
		while(rs.next())
		{
			Event event = new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
					rs.getInt(5),LocalDateTime.parse(rs.getString(6)),LocalDateTime.parse(rs.getString(7)));
			unRegisteredEvents.add(event);
		}
		return unRegisteredEvents;
	}
	
	@Override
	public ArrayList<Event> getRegisteredEventsByEmployeeId(int employeeId) throws SQLException,ClassNotFoundException
	{
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("select * from events where event_id in "
				+ "(select event_id from registrations where employee_id = ?)");
		pstmt.setInt(1, employeeId);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Event> registeredEvents = new ArrayList<>();
		while(rs.next())
		{
			Event event = new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
					rs.getInt(5),LocalDateTime.parse(rs.getString(6)),LocalDateTime.parse(rs.getString(7)));
			registeredEvents.add(event);
		}
		return registeredEvents;
	}
	
	@Override
	public boolean insertEvent(Event event) throws ClassNotFoundException, SQLException {
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("insert into events values(?,?,?,?,?,?,?)");
		pstmt.setInt(1, event.getEventID());
		pstmt.setString(2, event.getEventName());
		pstmt.setString(3, event.getEventLocation());
		pstmt.setString(4, event.getEventTime().toString());
		pstmt.setString(5, event.getEventRegistrationDeadline().toString());
		pstmt.setInt(6, event.getMaxRegistration());
		pstmt.setInt(7, event.getCurrentRegistration());
		int result = pstmt.executeUpdate();
		
		if (result > 0){
				return true; 
		}
		else{
				return false;
		}
	}
	
	@Override
	public boolean deleteEvent(int eventId) throws ClassNotFoundException, SQLException {

		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("delete from events where event_id =(?)");
		pstmt.setInt(1, eventId);
		int result = pstmt.executeUpdate();
		if (result > 0){
				return true;
		}
		else{
				return false;
		}

	}
	
	@Override
	public boolean updateEventName(int eventId,String newName) throws ClassNotFoundException, SQLException
	{
		Connection connection = DBConnection.getDBConnection();
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
	public boolean updateEventLocation(int eventId,String newLocation) throws SQLException, ClassNotFoundException
	{
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pStatement = connection.prepareStatement("update events set event_location = ? where event_id = ?");
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
	public boolean updateEventTime(int eventId,String newTime) throws ClassNotFoundException, SQLException
	{
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pStatement = connection.prepareStatement("update events set event_time = ? where event_id = ?");
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
	public boolean updateEventRegistrationDeadline(int eventId,String newDeadLine) throws ClassNotFoundException, SQLException
	{
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pStatement = connection.prepareStatement("update events set event_registration_deadline = ? where event_id = ?");
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
	public boolean updateEvent(int eventId, Event newEvent) throws ClassNotFoundException, SQLException {
		deleteEvent(eventId);
        return insertEvent(newEvent);
        }

	@Override
	public ArrayList<Event> getAllEvents() throws ClassNotFoundException, SQLException
	{
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("select * from events");
		ArrayList<Event> events = new ArrayList<>();
		
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Event event = new Event(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
					rs.getInt(5),LocalDateTime.parse(rs.getString(6)),LocalDateTime.parse(rs.getString(7)));
			events.add(event);
		}
		return events;
	}

	
	@Override
	public boolean incrementCurrentRegistration(int eventId) throws SQLException, ClassNotFoundException {
		
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update events set registration_till_date = registration_till_date+1"
				+ "where event_id = ?");
		preparedStatement.setInt(1, eventId);
		int result = preparedStatement.executeUpdate();
		if(result>0){
			return true;
		}
		else{
			return false;
		}
	}

	
	@Override
	public boolean decrementCurrentRegistration(int eventId) throws SQLException, ClassNotFoundException {
		
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("update events set registration_till_date = registration_till_date-1"
				+ "where event_id = ?");
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