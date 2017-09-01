package org.observer.impl;

public class GrabStocks {

	public static void main(String[] args) {
		StockGrabber grabber= new StockGrabber();
		StockObserver observer= new StockObserver(grabber);
		grabber.setApplePrice(100);
		System.out.println( " ------------------------- ");
		grabber.setGoogPrice(101);
		System.out.println( " ------------------------- ");
		grabber.setIbmPrice(102);
		System.out.println( " ------------------------- ");
		
		StockObserver observer2= new StockObserver(grabber);
		grabber.setApplePrice(104);
		System.out.println( " ------------------------- ");
		grabber.setGoogPrice(105);
		System.out.println( " ------------------------- ");
		grabber.setIbmPrice(106);
		System.out.println( " ------------------------- ");
		
		grabber.unregister(observer);
		grabber.setApplePrice(109);
		System.out.println( " ------------------------- ");
		grabber.setGoogPrice(108);
		System.out.println( " ------------------------- ");
		grabber.setIbmPrice(107);
		System.out.println( " ------------------------- ");
	}
}
