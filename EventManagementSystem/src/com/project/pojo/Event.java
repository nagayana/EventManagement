package com.project.pojo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Event {
    public Event(){
    	
    }

	
	private int eventID;
	private String eventName;
	private String eventLocation;
	private LocalDateTime eventTime;
	private LocalDateTime eventRegistrationDeadline;
	private int maxRegistration;
	private int currentRegistration;
	
	
	
	
	public Event(int eventID, String eventName, String eventLocation, int maxRegistration, 
			int currentRegistration,LocalDateTime eventTime,LocalDateTime eventRegistrationDeadline) {
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
	public LocalDateTime getEventTime() {
		return eventTime;
	}
	public void setEventTime(LocalDateTime localDateTime) {
		this.eventTime = localDateTime;
	}
	public LocalDateTime getEventRegistrationDeadline() {
		return eventRegistrationDeadline;
	}
	public void setEventRegistrationDeadline(LocalDateTime localDateTime) {
		this.eventRegistrationDeadline = localDateTime;
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
