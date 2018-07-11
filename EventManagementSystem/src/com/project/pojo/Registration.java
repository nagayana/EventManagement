package com.project.pojo;

public class Registration {
	
	private int employeeID;
	private int eventID;
	
	public Registration(int employeeID, int eventID) {
		super();
		this.employeeID = employeeID;
		this.eventID = eventID;
	}
	
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getEventID() {
		return eventID;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

}
