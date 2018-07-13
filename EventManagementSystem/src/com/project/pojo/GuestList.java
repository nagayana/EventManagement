package com.project.pojo;

public class GuestList {
	int designationId;
	int eventId;

	public int getDesignationId() {
		return designationId;
	}

	@Override
	public String toString() {
		return "GuestList [designationId=" + designationId + ", eventId=" + eventId + "]";
	}

	public GuestList(int designationId, int eventId) {
		super();
		this.designationId = designationId;
		this.eventId = eventId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

}
