package com.project.dao;
import java.util.ArrayList;

import com.project.pojo.Event;

public interface EventDao {
	Event searchEvent(int eventId);
	boolean insertEvent(Event event);
	boolean deleteEvent(int eventId);
	boolean updateEventName(int eventId,String newName);
	boolean updateEventTime(int eventId,String newTime);
	boolean updateEventLocation(int eventId,String newLocation);
	boolean updateEventRegistrationDeadline(int eventId,String newDeadline);
	boolean updateEvent(int eventid, Event newEvent);
	ArrayList<Event> getAllEvents(); 
}
