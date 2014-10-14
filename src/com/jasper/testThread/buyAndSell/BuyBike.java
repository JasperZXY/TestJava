package com.jasper.testThread.buyAndSell;

public interface BuyBike extends Runnable {
	@Override
	public void run();
	
	public void buy();

}
