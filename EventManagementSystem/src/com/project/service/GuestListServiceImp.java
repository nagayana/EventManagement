package com.project.service;

import java.util.ArrayList;

import com.project.dao.GuestListDao;
import com.project.dao.GuestListImp;
import com.project.pojo.GuestList;

public class GuestListServiceImp implements GuestListService{

	@Override
	public ArrayList<GuestList> generateGuestList(int eventId) {
		GuestListDao guestdao=new GuestListImp(); 
		return guestdao.searchGuestList(eventId);
		
	}

	@Override
	public boolean upadteGuestList(int designationId, int eventId, int newdesignationId) {
		GuestListDao guestdao=new GuestListImp(); 
		guestdao.deleteGuest(designationId,eventId);
		GuestList guestList=new GuestList();
		guestList.setDesignationId(newdesignationId);
		guestList.setEventId(eventId);
		return guestdao.insertGuest(guestList);
		 
	}

	@Override
	public boolean deleteGuestList(int designationId, int eventId) {
		GuestListDao guestdao=new GuestListImp(); 
		return guestdao.deleteGuest(designationId,eventId);
		
	}

	@Override
	public boolean insertGuestList(int designationId, int eventId) {
		GuestListDao guestdao=new GuestListImp();
		GuestList guest=new GuestList(designationId,eventId);
		return guestdao.insertGuest(guest);
		
	}

}
