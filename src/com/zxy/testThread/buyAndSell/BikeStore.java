package com.zxy.testThread.buyAndSell;


/**
 * 卖自行车的商店
 * @author Jasper
 */
public class BikeStore implements SellBike {
	private Boolean isRacingBike = false;
	private Bike bike = null;
	
	public BikeStore() {
	}
	public BikeStore(Bike bike) {
		this.setBike(bike);
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
			sell();
		}
	}

	@Override
	public void sell() {
		synchronized(bike) {
			if(isRacingBike) {
				bike.setType("跑车");
				try {   //顾客说要改装一辆跑车，马上来
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				bike.setPrice(2000);  //改装跑车贵了点
			} else {
				bike.setType("普通自行车");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				bike.setPrice(100);
				isRacingBike = !isRacingBike;
			}
			bike.notifyAll();
		}
	}

}
