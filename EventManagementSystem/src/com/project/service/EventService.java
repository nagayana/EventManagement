package com.project.service;

import java.util.ArrayList;

import com.project.pojo.Event;

public interface EventService {
	Event getEvent(int eventId);
	ArrayList<Event> getAllEvents(); 
	boolean insertEvent(Event event);
	boolean updateEventTime(int eventId,String newTime);
	boolean updateEventName(int eventId,String newName);
	boolean updateEventLocation(int eventId,String newLocation);
	boolean updateEventRegistrationDeadline(int eventId,String newDeadline);
	
}
