package com.project.service;

import com.project.dao.GuestListDao;
import com.project.dao.GuestListImp;
import com.project.pojo.GuestList;

public class GuestListServiceImp implements GuestListService{

	@Override
	public GuestList generateGuestList(int eventId) {
		GuestListDao guestdao=new GuestListImp(); 
		GuestList guestlist=guestdao.searchGuestList(eventId);
		return guestlist;
	}

	@Override
	public boolean upadteGuestList(int designationId, int eventId, int newdesignationId) {
		GuestListDao guestdao=new GuestListImp(); 
		GuestList guestlist=guestdao.searchGuestList(eventId);
		guestdao.deleteGuest(designationId,eventId);
		guestlist.setDesignationId(newdesignationId);
		guestlist.setEventId(newdesignationId);
		guestdao.insertGuest(guestlist);
		
		
		return false;
	}

	@Override
	public boolean deleteGuestList(int eventId, int designationId) {
		GuestListDao guestdao=new GuestListImp(); 
		guestdao.deleteGuest(eventId,designationId);
		return false;
	}

}
