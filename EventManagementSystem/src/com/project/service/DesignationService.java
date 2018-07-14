package com.project.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.project.pojo.Designation;

public interface DesignationService {
	ArrayList<Designation> searchDesignation(int designationId) throws ClassNotFoundException, SQLException;
}
