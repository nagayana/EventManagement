package com.project.service;

import com.project.pojo.Event;
import com.project.pojo.GuestList;

public interface GuestListService {
	GuestList generateGuestList(int eventId);	
	boolean upadteGuestList(int designationId,int eventId, int newdesignationId);
	boolean deleteGuestList(int designationId,int eventId);

}
