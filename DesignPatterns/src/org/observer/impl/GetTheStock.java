package org.observer.impl;

import java.text.DecimalFormat;

import org.observer.Subject;

public class GetTheStock implements Runnable{

	private int startTime;
	private String stock;
	private double price;
	
	private Subject stockGrabber;
	
	public GetTheStock(Subject stockGrabber, int startTime, String stock, double newPrice) {
		
		this.stockGrabber = stockGrabber;
		this.startTime = startTime;
		this.stock = stock;
		price = newPrice;
		
	}
	@Override
	public void run() {
		for (int i = 0; i <= 20; i++) {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			double randNum = (Math.random()* (.07)) -.03;
			DecimalFormat d= new DecimalFormat("#.##");
			price = Double.valueOf(d.format(price + randNum));
			if(stock == "IBM"){
				((StockGrabber)stockGrabber).setIbmPrice(price);
			}
			if(stock == "APPLE"){
				((StockGrabber)stockGrabber).setApplePrice(price);
			}
			if(stock == "GOOG"){
				((StockGrabber)stockGrabber).setGoogPrice(price);
			}
		}
	}
	public static void main(String[] args) {
		
	}
}
