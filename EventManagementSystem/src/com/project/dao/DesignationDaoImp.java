package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.pojo.Attraction;
import com.project.pojo.Designation;

public class DesignationDaoImp implements DesignationDao {

	private Connection con=null;
	private PreparedStatement psmt=null;
	private Statement smt=null;

	public boolean insertDesignation(Designation designation) throws SQLException, ClassNotFoundException {
		
		
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection("jdbc:postgresql://127."
					+ "0.0.1:5432/eventmanagementsystem", "postgres", "admin");
			
		    int id=designation.getDesignationId();
		    String name=designation.getDesignationName();
		    
		    psmt=con.prepareStatement("insert into attraction values(?,?)");
		    psmt.setInt(1, id);
		    psmt.setString(2, name);
		   
		    
		    int rows=psmt.executeUpdate();
		    if(rows>0)
				System.out.println("Record Inserted");
			else
				System.out.println("Unable to Insert Record");
		return false;
		
	}

	
	public boolean deleteDesignation(int designationId)throws SQLException, ClassNotFoundException {
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eventmanagementsystem",
				"postgres", "admin");
		smt=con.createStatement();
		String s="delete from designation where desiganation_id="+designationId;
		int check=smt.executeUpdate(s);
	    
		if(check>0)
			return true;
		else
			return false;
	}


	public boolean updateDesignation(int designationId, Designation designation)throws SQLException, ClassNotFoundException {
         deleteDesignation(designationId);
         insertDesignation(designation);
         return false;
	} 


	public ArrayList<Designation> searchDesignation(int designationId) throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");
		con=DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/eventmanagementsystem",
				"postgres", "admin");
		smt=con.createStatement();
		ArrayList<Designation> designationList=new ArrayList<>();
		ResultSet rs=smt.executeQuery("select count(*) from designation where designation_id="+designationId);
		Designation obj=new Designation();
	    if(rs.next()==true)
	    {
	    	obj.setDesignationId(rs.getInt(1));
		    obj.setDesignationName(rs.getString(2));
		    designationList.add(obj);
	    }
	    
	    return designationList;
	    
	    
	}


	

	

}
