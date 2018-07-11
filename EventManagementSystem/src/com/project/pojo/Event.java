package com.project.pojo;

public class Event {
	
	private int eventID;
	private String eventName;
	private String eventLocation;
	private String eventTime;
	private String eventRegistrationDeadline;
	private int maxRegistration;
	private int currentRegistration;
	
	
	
	
	public Event(int eventID, String eventName, String eventLocation, String eventTime,
			String eventRegistrationDeadline, int maxRegistration, int currentRegistration) {
		super();
		this.eventID = eventID;
		this.eventName = eventName;
		this.eventLocation = eventLocation;
		this.eventTime = eventTime;
		this.eventRegistrationDeadline = eventRegistrationDeadline;
		this.maxRegistration = maxRegistration;
		this.currentRegistration = currentRegistration;
	}
	
	public int getEventID() {
		return eventID;
	}
	public void setEventID(int eventID) {
		this.eventID = eventID;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	public String getEventTime() {
		return eventTime;
	}
	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}
	public String getEventRegistrationDeadline() {
		return eventRegistrationDeadline;
	}
	public void setEventRegistrationDeadline(String eventRegistrationDeadline) {
		this.eventRegistrationDeadline = eventRegistrationDeadline;
	}
	public int getMaxRegistration() {
		return maxRegistration;
	}
	public void setMaxRegistration(int maxRegistration) {
		this.maxRegistration = maxRegistration;
	}
	public int getCurrentRegistration() {
		return currentRegistration;
	}
	public void setCurrentRegistration(int currentRegistration) {
		this.currentRegistration = currentRegistration;
	}

	@Override
	public String toString() {
		return "Event [eventID=" + eventID + ", eventName=" + eventName + ", eventLocation=" + eventLocation
				+ ", eventTime=" + eventTime + ", eventRegistrationDeadline=" + eventRegistrationDeadline
				+ ", maxRegistration=" + maxRegistration + ", currentRegistration=" + currentRegistration + "]";
	}
	
	
	
}
