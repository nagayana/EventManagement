package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.project.pojo.Designation;

public class DesignationDaoImp implements DesignationDao {

	public ArrayList<Designation> getDesignationList(int eventId) throws SQLException, ClassNotFoundException{
		ArrayList<Designation> designationList=new ArrayList<>();
		Connection con = DBConnection.getDBConnection();
		//PreparedStatement pStatement = con.prepareStatement("select * from designation");
		PreparedStatement pStatement = con.prepareStatement("select * from designation where designation_id not in(select designation_id from guestlist where event_id=?)");
		pStatement.setInt(1, eventId);
		ResultSet rs = pStatement.executeQuery();
		
	    while(rs.next())
	    {
	    	Designation designation = new Designation(rs.getInt(1), rs.getString(2));
		    designationList.add(designation);
	    }
	    return designationList;
	}

}
