package com.project.pojo;

public class Food {
	private int foodId, foodPrice, foodQuantity, eventId;
	private String foodName;

	public Food(int foodId, String foodName, int foodPrice, int foodQuantity, int eventId) {
		this.foodId=foodId;
		this.foodName=foodName;
		this.foodPrice=foodPrice;
		this.foodQuantity=foodQuantity;
		this.eventId=eventId;
	}

	public Food() {
		// TODO Auto-generated constructor stub
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public void setPrice(int price) {
		this.foodPrice = price;
	}

	public void setQuantity(int quantity) {
		this.foodQuantity = quantity;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getFoodId() {
		return foodId;
	}

	public int getPrice() {
		return foodPrice;
	}

	public int getQuantity() {
		return foodQuantity;
	}

	public int getEventId() {
		return eventId;
	}

	public String getFoodName() {
		return foodName;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodPrice=" + foodPrice + ", foodQuantity=" + foodQuantity + ", eventId="
				+ eventId + ", foodName=" + foodName + "]";
	}

	
	

}
