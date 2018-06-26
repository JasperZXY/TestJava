package com.zxy.testThread.buyAndSell;

public interface BuyBike extends Runnable {
	@Override
	public void run();
	
	public void buy();

}
