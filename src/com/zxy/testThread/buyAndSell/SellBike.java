package com.zxy.testThread.buyAndSell;

public interface SellBike extends Runnable {
	@Override
	public void run();
	
	public void sell();

}
