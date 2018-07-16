package com.project.dao;
import com.project.pojo.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface AttractionDaoInterface {
	
	boolean insertAttraction(Attraction attraction) throws SQLException, ClassNotFoundException;
	boolean deleteAttraction(int attractionId) throws SQLException, ClassNotFoundException;
	boolean updateAttraction(int attractionId,Attraction attraction) throws SQLException, ClassNotFoundException;
	ArrayList<Attraction> getEventAttractions(int eventId) throws SQLException, ClassNotFoundException;
    Attraction getAttractionById(int attractionId) throws SQLException, ClassNotFoundException;
    AttractionDaoImplement attractionObj=new AttractionDaoImplement();
    boolean deleteAttractionByEvenetId(int eventId)throws ClassNotFoundException, SQLException;
}
