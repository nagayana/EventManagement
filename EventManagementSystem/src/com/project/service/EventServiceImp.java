package com.project.service;

import java.util.ArrayList;

import com.project.dao.EventDaoImp;
import com.project.pojo.Event;

public class EventServiceImp implements EventService{

	@Override
	public boolean updateEventLocation(int eventId,String newLocation) {
		Event event = getEvent(eventId);
		event.setEventLocation(newLocation);
		boolean result = insertEvent(event);
		return result;
	}

	@Override
	public boolean updateEventTime(int eventId, String newTime) {
		Event event = getEvent(eventId);
		event.setEventTime(newTime);
		boolean result = insertEvent(event);
		return result;
	}

	@Override
	public boolean updateEventName(int eventId, String newName) {
		Event event = getEvent(eventId);
		event.setEventName(newName);
		boolean result = insertEvent(event);
		return result;
	}
	
	public Event getEvent(int eventId)
	{
		EventDaoImp daoObj = new EventDaoImp();
		Event event = daoObj.searchEvent(eventId);
		return event;
	}
	
	public boolean insertEvent(Event event)
	{
		EventDaoImp daoObj = new EventDaoImp();
		boolean result = daoObj.insertEvent(event);
		return result;
	}
	
	public ArrayList<Event>getAllEvents()
	{
		EventDaoImp daoObj = new EventDaoImp();
		ArrayList<Event> events = daoObj.getAllEvents();
		return events;
	}
}
