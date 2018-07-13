package com.project.dao;
import com.project.pojo.*;

import java.sql.SQLException;
import java.util.List;

public interface AttractionDaoInterface {
	
	boolean insertAttraction(Attraction attraction) throws SQLException, ClassNotFoundException;
	boolean deleteAttraction(int attractionId) throws SQLException, ClassNotFoundException;
	boolean updateAttraction(int attractionId,Attraction attraction) throws SQLException, ClassNotFoundException;
	List<Attraction> searchAttraction(int eventId) throws SQLException, ClassNotFoundException;
    Attraction getAttractionById(int attractionId) throws SQLException, ClassNotFoundException;
}
