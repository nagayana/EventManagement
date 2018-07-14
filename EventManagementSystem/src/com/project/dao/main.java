package com.project.dao;

import java.sql.SQLException;

import com.project.pojo.Attraction;
import com.project.pojo.Designation;

public class main {

	public static void main(String[] args) {
		//Attraction obj=new Attraction(7,"aaa","bbb",3,7,9);
		//AttractionDaoImplement obj1=new AttractionDaoImplement();
		Designation obj=new Designation(10,"it");
		DesignationDaoImp obj1=new DesignationDaoImp();
		try {
			obj1.insertDesignation(obj);
			//obj1.deleteAttraction(5);
			//Attraction a=obj1.searchAttraction(6);
			//System.out.println(a);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
