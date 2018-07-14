package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.project.pojo.Event;

public interface EventService {
	Event getEvent(int eventId) throws ClassNotFoundException, SQLException;
	ArrayList<Event> getAllEvents()throws ClassNotFoundException, SQLException; 
	boolean insertEvent(Event event) throws ClassNotFoundException, SQLException ;
	boolean updateEventTime(int eventId,String newTime) throws ClassNotFoundException, SQLException ;
	boolean updateEventName(int eventId,String newName) throws ClassNotFoundException, SQLException;
	boolean updateEventLocation(int eventId,String newLocation) throws ClassNotFoundException, SQLException ;
	boolean updateEventRegistrationDeadline(int eventId,String newDeadline) throws ClassNotFoundException, SQLException ;
	
}
