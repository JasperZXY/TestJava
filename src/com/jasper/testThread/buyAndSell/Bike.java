package com.jasper.testThread.buyAndSell;

public class Bike {
	private String type;
	private int price;
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "type->" + type + "  price->" + price;
	}

}
