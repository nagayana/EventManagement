package com.project.pojo;

public class Attraction {
	private int attractionId;
	private String name;
	private String coordinatorName;
	private String duration;
	private double price;
	private int eventId;
	
	public Attraction(int attractionId, String name, String coordinatorName, String duration, double price, int eventId) {
		super();
		this.attractionId = attractionId;
		this.name = name;
		this.coordinatorName = coordinatorName;
		this.duration = duration;
		this.price = price;
		this.eventId = eventId;
	}
	

	public Attraction() {
		super();
	}


	public int getAttractionId() {
		return attractionId;
	}

	public void setAttractionId(int attractionId) {
		this.attractionId = attractionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCoordinatorName() {
		return coordinatorName;
	}

	public void setCoordinatorName(String coordinatorName) {
		this.coordinatorName = coordinatorName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}


	@Override
	public String toString() {
		return "Attraction [attractionId=" + attractionId + ", name=" + name + ", coordinatorName=" + coordinatorName
				+ ", duration=" + duration + ", price=" + price + ", eventId=" + eventId + "]";
	}
	
	

}
