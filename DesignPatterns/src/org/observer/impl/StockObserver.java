package org.observer.impl;

import org.observer.Observer;
import org.observer.Subject;

public class StockObserver implements Observer{

	private double ibmPrice;
	private double applePrice; 
	private double googPrice;
	private int observerId;
	private static int observerTrackerId = 0;
	private final Subject stockGrabber;
	
	public StockObserver(StockGrabber grabber) {
		stockGrabber = grabber;
		this.setObserverId(observerTrackerId++);
		stockGrabber.register(this);
	}
	public double getIbmPrice() {
		return ibmPrice;
	}
	public void setIbmPrice(double ibmPrice) {
		this.ibmPrice = ibmPrice;
	}
	public double getApplePrice() {
		return applePrice;
	}
	public void setApplePrice(double applePrice) {
		this.applePrice = applePrice;
	}
	public double getGoogPrice() {
		return googPrice;
	}
	public void setGoogPrice(double googPrice) {
		this.googPrice = googPrice;
	}
	public static int getObserverTrackerId() {
		return observerTrackerId;
	}
	public static void setObserverTrackerId(int observerTrackerId) {
		StockObserver.observerTrackerId = observerTrackerId;
	}
	@Override
	public void update(double ibmPrice, double applePrice, double googPrice) {
		System.out.println("Observer Id: " + observerId);
		this.ibmPrice = ibmPrice;
		this.applePrice = applePrice;
		this.googPrice = googPrice;
		System.out.println("IBM price: "  + ibmPrice);
		System.out.println("Apple price: "  + applePrice);
		System.out.println("Google price: "  + googPrice);
	}
	public int getObserverId() {
		return observerId;
	}
	public void setObserverId(int observerId) {
		this.observerId = observerId;
	}

}
