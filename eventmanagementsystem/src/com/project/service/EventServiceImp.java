package com.project.service;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import com.project.dao.EventDaoImp;
import com.project.pojo.Event;

public class EventServiceImp implements EventService{

	EventDaoImp DbObject;
	public EventServiceImp() {
		DbObject = new EventDaoImp(); 
	}
	
	@Override
	public boolean updateEventLocation(int eventId,String newLocation) throws SQLException,ClassNotFoundException{
		return DbObject.updateEventLocation(eventId, newLocation);
	}

	@Override
	public boolean updateEventTime(int eventId, LocalDateTime localDateTime) throws SQLException,ClassNotFoundException{
		return DbObject.updateEventTime(eventId, localDateTime);
	}

	@Override
	public boolean updateEventName(int eventId, String newName) throws SQLException,ClassNotFoundException{
		return DbObject.updateEventName(eventId, newName);
	}
	
	@Override
	public boolean updateEventRegistrationDeadline(int eventId, LocalDateTime localDateTime) throws SQLException,ClassNotFoundException{
		return DbObject.updateEventRegistrationDeadline(eventId, localDateTime);
	}
	
	@Override
	public Event getEvent(int eventId) throws SQLException,ClassNotFoundException{
		return DbObject.getEvent(eventId);
	}

	@Override
	public boolean insertEvent(Event event) throws SQLException,ClassNotFoundException{
		return DbObject.insertEvent(event);
	}
	

	@Override
	public ArrayList<Event> getAllEvents() throws SQLException,ClassNotFoundException{
		return DbObject.getAllEvents();
	}

	@Override

	public boolean deleteEvent(int eventId) throws SQLException, ClassNotFoundException {
		return DbObject.deleteEvent(eventId);
	}

	@Override
	public boolean updateEvent(int eventId, Event newEvent) throws SQLException, ClassNotFoundException {
		return DbObject.updateEvent(eventId, newEvent);
	}


	public ArrayList<Event> getRegisteredEventsByEmployeeId(int employeeId) throws SQLException,ClassNotFoundException{
		ArrayList<Event> allRegisteredEvents = DbObject.getRegisteredEventsByEmployeeId(employeeId);
		return filterEventsByRegistrationDeadline(allRegisteredEvents);
	}
	
	@Override
	public ArrayList<Event> getUnregisteredEventsByEmployeeId(int employeeId) throws SQLException,ClassNotFoundException{
		
		ArrayList<Event> allUnregisteredEvents = DbObject.getUnregisteredEventsByEmployeeId(employeeId);
		return filterEventsByRegistrationDeadline(allUnregisteredEvents);
	}
	
	
	
	private ArrayList<Event> filterEventsByRegistrationDeadline(ArrayList<Event> allEvents){
		
		ArrayList<Event> filteredEvents = new ArrayList<>();
		for(Event event: allEvents) {
			if(event.getEventRegistrationDeadline().isAfter(LocalDateTime.now())){
				filteredEvents.add(event);
			}
		}
		return filteredEvents;
	}
}
