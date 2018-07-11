package com.project.pojo;

public class FoodDatabase {
	
	private int foodId;
	private double price;
	private String foodName;
	public FoodDatabase(int foodId, double price, String foodName) {
		super();
		this.foodId = foodId;
		this.price = price;
		this.foodName = foodName;
	}
	public FoodDatabase() {
		super();
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	
	
	

}
