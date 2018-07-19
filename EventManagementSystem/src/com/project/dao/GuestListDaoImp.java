package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.EventListener;

import com.project.pojo.GuestList;

public class GuestListDaoImp implements GuestListDao {

	@Override
	public ArrayList<GuestList> getEventGuestList(int eventId) throws SQLException,ClassNotFoundException{
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("select * from guestlist where event_id = ?");
		pstmt.setInt(1, eventId);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<GuestList> guestList=new ArrayList<>();
		while(rs.next()) {
			GuestList gListElement = new GuestList(rs.getInt(1), rs.getInt(2));
                guestList.add(gListElement);
			}
		return guestList;
	}

	@Override
	public boolean insertGuest(GuestList guest) throws ClassNotFoundException, SQLException {
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("insert into guestlist values(?,?)");
		pstmt.setInt(1, guest.getDesignationId());
		pstmt.setInt(2, guest.getEventId());
		int result = pstmt.executeUpdate();
		
		if (result > 0){ 
			return true;
		}
		else{
			return false;
		}
	}

	
	
	@Override
	public ArrayList<Integer> getEventIdByDesignationId(int designationId) throws SQLException,ClassNotFoundException
	{
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("select event_id from guestlist where designation_id = ?");
		pstmt.setInt(1, designationId);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Integer> eventIdList = new ArrayList<>();
		while(rs.next())
		{
			eventIdList.add(rs.getInt(1));
		}
		return eventIdList;
	}

	@Override
	public boolean deleteGuestListByEventId(int eventId) throws ClassNotFoundException, SQLException {
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("delete from guestlist where event_id = ?");
		pstmt.setInt(1, eventId);
		int result = pstmt.executeUpdate();
		if (result > 0){
				return true;
		}
		else{
				return false;
		}
	}

	

	@Override
	public boolean deleteGuest(int designationId, int eventId) throws SQLException,ClassNotFoundException{
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("delete from guestlist where event_id = ? and designation_id = ?");
		pstmt.setInt(1, eventId);
		pstmt.setInt(2, designationId);
		int result = pstmt.executeUpdate();
		if (result > 0){
				return true;
		}
		else{
				return false;
		}
	}

	@Override
	public ArrayList<Integer> DesignationByEventId(int eventId) throws ClassNotFoundException, SQLException {
		Connection connection = DBConnection.getDBConnection();
		PreparedStatement pstmt = connection.prepareStatement("select designation_id from guestlist where event_id = ?");
		pstmt.setInt(1, eventId);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<Integer> designationIdList = new ArrayList<>();
		while(rs.next())
		{
			designationIdList.add(rs.getInt(1));
		}
		return designationIdList;
	}
	
	


}
