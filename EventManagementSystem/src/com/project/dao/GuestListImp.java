package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.pojo.Attraction;
import com.project.pojo.Event;
import com.project.pojo.GuestList;

public class GuestListImp implements GuestListDao {
	GuestList guest = null;

	@Override
	public ArrayList<GuestList> searchGuestList(int eventId) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		 ArrayList<GuestList> guestList=new ArrayList<>();
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "admin");
			pstmt = connection.prepareStatement("select* from Events where Event_Id =(?)");
			pstmt.setInt(1, guest.getEventId());

			ResultSet rs = pstmt.executeQuery();
			while(rs.next() == true) {
				guest.setDesignationId(rs.getInt(1));
				guest.setEventId(rs.getInt(2));
                guestList.add(guest);
			}

		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// 5.close the connection
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return guestList;
	}

	@Override
	public boolean insertGuest(GuestList guest) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "admin");
			pstmt = connection.prepareStatement("insert into guestlist values(?,?)");
			pstmt.setInt(1, guest.getEventId());
			pstmt.setInt(2, guest.getDesignationId());
			int rows = pstmt.executeUpdate();

			if (rows > 0)
				System.out.println("Record Inserted");
			else
				System.out.println("Unable to Insert Record");

		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// 5.close the connection
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return false;

	}

	@Override
	public boolean deleteGuest(int designationId, int eventId) {
		Connection connection = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/postgres", "postgres", "admin");
			pstmt = connection.prepareStatement("delete from guestlist where Event_Id =(?)and Designation_Id=(?)");
			pstmt.setInt(1, guest.getEventId());
			pstmt.setInt(2, guest.getDesignationId());

			int rows = pstmt.executeUpdate();

			if (rows > 0)
				System.out.println("Record deleted");
			else
				System.out.println("Unable to delete Record");

		} catch (ClassNotFoundException exception) {
			exception.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// 5.close the connection
			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}
		return false;

	}

}
