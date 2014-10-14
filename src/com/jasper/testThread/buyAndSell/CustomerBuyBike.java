package com.jasper.testThread.buyAndSell;

public class CustomerBuyBike implements BuyBike {
	private Bike bike = null;
	
	public CustomerBuyBike(){}
	public CustomerBuyBike(Bike bike) {
		this.bike = bike;
	}
	public void setBike(Bike bike) {
		this.bike = bike;
	}

	public Bike getBike() {
		return bike;
	}
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			synchronized (bike) {
				try {
					bike.wait();
					Thread.sleep(10);  //看一下再确定
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				buy();
			}
		}
	}

	@Override
	public void buy() {
		System.out.println(bike);
	}


}
