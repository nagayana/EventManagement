package com.project.service;

import java.sql.SQLException;
import java.util.List;

import com.project.dao.AttractionDaoImplement;
import com.project.pojo.Attraction;

public class AttractionServiceImp implements AttractionService {

	@Override
	public boolean insertAttraction(Attraction attraction) throws ClassNotFoundException, SQLException {
		AttractionDaoImplement attractionObj=new AttractionDaoImplement();
		return attractionObj.insertAttraction(attraction);
	}

	@Override
	public boolean deleteAttraction(int attractionId) throws ClassNotFoundException, SQLException {
		AttractionDaoImplement attractionObj=new AttractionDaoImplement();
		return attractionObj.deleteAttraction(attractionId);
	}

	@Override
	public List<Attraction> getAttractionList(int eventId) throws ClassNotFoundException, SQLException {
		AttractionDaoImplement attractionObj=new AttractionDaoImplement();
		return attractionObj.searchAttraction(eventId);
	}

	@Override
	public boolean updateAttraction(int attractionId, Attraction attraction) throws ClassNotFoundException, SQLException {
		AttractionDaoImplement attractionObj=new AttractionDaoImplement();
		return attractionObj.updateAttraction(attractionId, attraction);
	}

	@Override
	public Attraction getAttractionById(int attractionId) throws ClassNotFoundException, SQLException {
		AttractionDaoImplement attractionObj=new AttractionDaoImplement();
		return attractionObj.getAttractionById(attractionId);
	}

	
}
