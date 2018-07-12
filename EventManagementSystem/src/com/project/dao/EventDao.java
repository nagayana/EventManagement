package com.project.dao;

import com.project.pojo.Event;

public interface EventDao {
	Event searchEvent(int eventId);

	boolean insertEvent(Event event);

	boolean deleteEvent(int eventId);

	boolean updateEvent(int eventid, Event newEvent);

}
