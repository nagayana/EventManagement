package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.project.pojo.Event;

public interface EventService {
	Event getEvent(int eventId) throws SQLException, ClassNotFoundException;
	ArrayList<Event> getAllEvents() throws SQLException, ClassNotFoundException; 
	boolean insertEvent(Event event) throws SQLException, ClassNotFoundException;
	boolean updateEventTime(int eventId,String newTime) throws SQLException, ClassNotFoundException;
	boolean updateEventName(int eventId,String newName) throws SQLException, ClassNotFoundException;
	boolean updateEventLocation(int eventId,String newLocation) throws SQLException, ClassNotFoundException;
	boolean updateEventRegistrationDeadline(int eventId,String newDeadline) throws SQLException, ClassNotFoundException;
	boolean deleteEvent(int eventId) throws SQLException, ClassNotFoundException;
	boolean updateEvent(int eventid, Event newEvent) throws SQLException,ClassNotFoundException;;
	ArrayList<Event> getRegisteredEventsByEmployeeId(int employeeId) throws SQLException, ClassNotFoundException;
	ArrayList<Event> getUnregisteredEventsByEmployeeId(int employeeId) throws SQLException, ClassNotFoundException;
	
}
