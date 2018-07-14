package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.project.dao.EventDaoImp;
import com.project.pojo.Event;

public class EventServiceImp implements EventService{

	EventDaoImp DbObject;
	public EventServiceImp() {
		DbObject = new EventDaoImp();
	}
	
	@Override
	public boolean updateEventLocation(int eventId,String newLocation) throws ClassNotFoundException, SQLException{
		return DbObject.updateEventLocation(eventId, newLocation);
	}

	@Override
	public boolean updateEventTime(int eventId, String newTime) throws ClassNotFoundException, SQLException {
		return DbObject.updateEventTime(eventId, newTime);
	}

	@Override
	public boolean updateEventName(int eventId, String newName) throws ClassNotFoundException, SQLException {
		return DbObject.updateEventName(eventId, newName);
	}
	
	@Override
	public boolean updateEventRegistrationDeadline(int eventId, String newDeadLine) throws ClassNotFoundException, SQLException{
		return DbObject.updateEventRegistrationDeadline(eventId, newDeadLine);
	}
	
	@Override
	public Event getEvent(int eventId) throws ClassNotFoundException, SQLException{
		return DbObject.searchEvent(eventId);
	}

	@Override
	public boolean insertEvent(Event event) throws ClassNotFoundException, SQLException{
		return DbObject.insertEvent(event);
	}
	

	@Override
	public ArrayList<Event> getAllEvents() throws ClassNotFoundException, SQLException{
		return DbObject.getAllEvents();

	}

}
