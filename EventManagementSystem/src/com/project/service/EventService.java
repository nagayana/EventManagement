package com.project.service;

import java.util.ArrayList;

import com.project.pojo.Event;

public interface EventService {
	boolean insertEvent(Event event);
	boolean updateEventLocation(int eventId,String newLocation);
	boolean updateEventTime(int eventId,String newTime);
	boolean updateEventName(int eventId,String newName);
	Event getEvent(int eventId);
	ArrayList<Event> getAllEvents();
}
