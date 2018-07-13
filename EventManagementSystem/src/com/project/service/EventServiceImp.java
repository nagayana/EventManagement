package com.project.service;

import java.util.ArrayList;
import com.project.dao.EventDaoImp;
import com.project.pojo.Event;

public class EventServiceImp implements EventService{

	EventDaoImp DbObject;
	public EventServiceImp() {
		DbObject = new EventDaoImp();
	}
	
	@Override
	public boolean updateEventLocation(int eventId,String newLocation) {
		return DbObject.updateEventLocation(eventId, newLocation);
	}

	@Override
	public boolean updateEventTime(int eventId, String newTime) {
		return DbObject.updateEventTime(eventId, newTime);
	}

	@Override
	public boolean updateEventName(int eventId, String newName) {
		return DbObject.updateEventName(eventId, newName);
	}
	
	@Override
	public boolean updateEventRegistrationDeadline(int eventId, String newDeadLine) {
		return DbObject.updateEventRegistrationDeadline(eventId, newDeadLine);
	}
	
	@Override
	public Event getEvent(int eventId){
		return DbObject.searchEvent(eventId);
	}

	@Override
	public boolean insertEvent(Event event){
		return DbObject.insertEvent(event);
	}
	
	@Override
	public ArrayList<Event> getAllEvents(){
		return DbObject.getAllEvents();
	}

}
