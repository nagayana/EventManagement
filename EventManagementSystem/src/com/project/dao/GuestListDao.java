package com.project.dao;

import com.project.pojo.Event;
import com.project.pojo.GuestList;

public interface GuestListDao {
	GuestList searchGuestList(int eventId);

	boolean deleteGuest(int designationId,int eventId);

	boolean insertGuest(GuestList guest);

	


}
