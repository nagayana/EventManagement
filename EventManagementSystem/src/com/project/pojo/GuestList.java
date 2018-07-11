package com.project.pojo;

public class GuestList {
	String designationId,eventId;

	public String getDesignationId() {
		return designationId;
	}

	@Override
	public String toString() {
		return "GuestList [designationId=" + designationId + ", eventId=" + eventId + "]";
	}

	public GuestList(String designationId, String eventId) {
		super();
		this.designationId = designationId;
		this.eventId = eventId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

}
