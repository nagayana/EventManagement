package com.project.service;

import java.sql.SQLException;
import java.util.List;

import com.project.pojo.Attraction;

public interface AttractionService {
	
	boolean insertAttraction(Attraction attraction) throws ClassNotFoundException, SQLException;
	boolean deleteAttraction(int attractionId) throws ClassNotFoundException, SQLException;
	List<Attraction> getAttractionList(int eventId) throws ClassNotFoundException, SQLException;
	boolean updateAttraction(int attractionId,Attraction attraction) throws ClassNotFoundException, SQLException;
	Attraction getAttractionById(int attractionId) throws ClassNotFoundException, SQLException;

}
