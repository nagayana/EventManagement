package com.project.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.project.pojo.GuestList;

public interface GuestListDao {
	ArrayList<GuestList> getEventGuestList(int eventId) throws SQLException,ClassNotFoundException;
	boolean insertGuest(GuestList guestListElement) throws SQLException,ClassNotFoundException;
	boolean deleteGuest(int designationId,int eventId) throws SQLException,ClassNotFoundException;
	ArrayList<Integer> getEventIdByDesignationId(int designationId) throws SQLException,ClassNotFoundException;
	boolean deleteGuestListByEventId(int eventId) throws ClassNotFoundException,SQLException;
	ArrayList<Integer> DesignationByEventId(int eventId) throws ClassNotFoundException,SQLException;
}
