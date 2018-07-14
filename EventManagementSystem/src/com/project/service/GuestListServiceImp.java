package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.project.dao.EventDaoImp;
import com.project.dao.GuestListDao;
import com.project.dao.GuestListImp;
import com.project.pojo.Event;
import com.project.pojo.GuestList;

public class GuestListServiceImp implements GuestListService{

	@Override
	public ArrayList<GuestList> generateGuestList(int eventId) throws ClassNotFoundException, SQLException {
		GuestListDao guestdao=new GuestListImp(); 
		return guestdao.getEventGuestList(eventId);
		
	}

	@Override
	public boolean upadteGuestList(int designationId, int eventId, int newdesignationId) throws ClassNotFoundException, SQLException {
		GuestListDao guestdao=new GuestListImp(); 
		guestdao.deleteGuest(designationId,eventId);
		GuestList guestList=new GuestList();
		guestList.setDesignationId(newdesignationId);
		guestList.setEventId(eventId);
		return guestdao.insertGuest(guestList);
		 
	}

	@Override
	public boolean deleteGuestList(int designationId, int eventId) throws ClassNotFoundException, SQLException {
		GuestListDao guestdao=new GuestListImp(); 
		return guestdao.deleteGuest(designationId,eventId);
		
	}

	@Override
	public boolean insertGuestList(int designationId, int eventId) throws ClassNotFoundException, SQLException {
		GuestListDao guestdao=new GuestListImp();
		GuestList guest=new GuestList(designationId,eventId);
		return guestdao.insertGuest(guest);
		
	}

	@Override
	public ArrayList<Event> getGuestEventList(int designationId) throws SQLException,ClassNotFoundException
	{
		GuestListImp guestList = new GuestListImp();
		ArrayList<Integer> eventIdList =  guestList.getEventIdByDesignationId(designationId);
		EventDaoImp eventDaoImp = new EventDaoImp();
		ArrayList<Event> eventList = new ArrayList<>();
		
		for(int eventId : eventIdList)
		{
			eventList.add(eventDaoImp.getEvent(eventId));
		}
		return eventList;
	}
}
