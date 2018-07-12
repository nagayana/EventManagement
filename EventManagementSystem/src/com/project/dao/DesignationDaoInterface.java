package com.project.dao;

import java.sql.SQLException;

import com.project.pojo.Attraction;
import com.project.pojo.Designation;

public interface DesignationDaoInterface {
	
	boolean insertDesignation(Designation designation) throws SQLException, ClassNotFoundException;
	boolean deleteDesignation(int designationId) throws SQLException, ClassNotFoundException;
	boolean updateDesignation(int designationId,Designation designation) throws SQLException, ClassNotFoundException;
	Designation searchDesignation(int designationId) throws SQLException, ClassNotFoundException;

}
