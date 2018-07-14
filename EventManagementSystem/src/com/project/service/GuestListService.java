package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;
import com.project.pojo.Event;
import com.project.pojo.GuestList;

public interface GuestListService {
	ArrayList<GuestList> generateGuestList(int eventId) throws ClassNotFoundException, SQLException;	
	boolean upadteGuestList(int designationId,int eventId, int newdesignationId) throws ClassNotFoundException, SQLException;
	boolean deleteGuestList(int designationId,int eventId) throws ClassNotFoundException, SQLException;
	boolean insertGuestList(int designationId, int eventId) throws ClassNotFoundException, SQLException;
	ArrayList<Event> getGuestEventList(int designationId) throws ClassNotFoundException,SQLException; 
}
