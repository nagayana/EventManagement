package com.project.service;

import java.util.ArrayList;

import com.project.pojo.Event;
import com.project.pojo.GuestList;

public interface GuestListService {
	ArrayList<GuestList> generateGuestList(int eventId);	
	boolean upadteGuestList(int designationId,int eventId, int newdesignationId);
	boolean deleteGuestList(int designationId,int eventId);
	boolean insertGuestList(int designationId, int eventId);

}
