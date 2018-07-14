package com.project.dao;

import java.util.ArrayList;

import com.project.pojo.Event;
import com.project.pojo.GuestList;

public interface GuestListDao {
	ArrayList<GuestList> searchGuestList(int eventId);

	boolean deleteGuest(int designationId,int eventId);

	boolean insertGuest(GuestList guest);

	


}
