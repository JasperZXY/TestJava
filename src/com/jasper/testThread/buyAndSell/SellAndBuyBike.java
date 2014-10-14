package com.jasper.testThread.buyAndSell;

public class SellAndBuyBike {
	public static void main(String []args) {
		Bike bike = new Bike();
		BikeStore bs = new BikeStore(bike);
		CustomerBuyBike cbb = new CustomerBuyBike(bike);
		new Thread(bs).start();
		new Thread(cbb).start();
	}

}
