package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.project.pojo.Designation;

public class DesignationDaoImp implements DesignationDao {

	public ArrayList<Designation> getDesignationList() throws SQLException, ClassNotFoundException{
		ArrayList<Designation> designationList=new ArrayList<>();
		Connection con = DBConnection.getDBConnection();
		PreparedStatement pStatement = con.prepareStatement("select * from designation");
		ResultSet rs = pStatement.executeQuery();
		
	    while(rs.next())
	    {
	    	Designation designation = new Designation(rs.getInt(1), rs.getString(2));
		    designationList.add(designation);
	    }
	    return designationList;
	}

}
