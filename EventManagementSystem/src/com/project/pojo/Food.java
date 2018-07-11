package com.project.pojo;

public class Food {
	private int foodId, price, quantity, eventId;
	private String foodName;

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getEventId() {
		return eventId;
	}

	public String getFoodName() {
		return foodName;
	}

	public Food(int foodId, int price, int quantity, int eventId, String foodName) {
		super();
		this.foodId = foodId;
		this.price = price;
		this.quantity = quantity;
		this.eventId = eventId;
		this.foodName = foodName;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", price=" + price + ", quantity=" + quantity + ", eventId=" + eventId
				+ ", foodName=" + foodName + "]";
	}

}
