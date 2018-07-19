package com.project.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import com.project.pojo.Designation;

public interface DesignationDao {
	ArrayList<Designation> getDesignationList(int eventId) throws SQLException, ClassNotFoundException;
}
