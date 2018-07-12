package com.project.dao;


import com.project.pojo.Event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventDaoimp implements EventDao {
	int eventId;
	String eventNAme, location, time, registrationDeadline, activeRegistration;
	Event event = null;

	@Override
	public Event searchEvent(int eventId) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
					"kanishka");
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

		}
		return event;

	}

	@Override
	public boolean insertEvent(Event event) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
					"kanishka");
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

		}
		return true;
	}

	@Override
	public boolean deleteEvent(int eventId) {

		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
					"kanishka");
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

		}
		return true;

	}
	

	@Override
	public boolean updateEvent(int eventId, Event newEvent) {
		 deleteEvent(eventId);
         insertEvent(event);
		return true;


}
}