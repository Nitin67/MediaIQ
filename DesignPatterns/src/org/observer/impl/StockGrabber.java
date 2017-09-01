package org.observer.impl;

import java.util.ArrayList;

import org.observer.Observer;
import org.observer.Subject;

public class StockGrabber implements Subject{

	private ArrayList<Observer> observers;
	
	private double ibmPrice;
	private double applePrice;
	private double googPrice;
	
	public StockGrabber() {
		observers = new ArrayList<Observer>();
	}
	
	public ArrayList<Observer> getObservers() {
		return observers;
	}

	public void setObservers(ArrayList<Observer> observers) {
		this.observers = observers;
	}

	public double getIbmPrice() {
		return ibmPrice;
	}

	public void setIbmPrice(double ibmPrice) {
		this.ibmPrice = ibmPrice;
		this.notifyObservers();
	}

	public double getApplePrice() {
		return applePrice;
	}

	public void setApplePrice(double applePrice) {
		this.applePrice = applePrice;
		this.notifyObservers();
	}

	public double getGoogPrice() {
		return googPrice;
	}

	public void setGoogPrice(double googPrice) {
		this.googPrice = googPrice;
		this.notifyObservers();
	}

	@Override
	public void register(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void unregister(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update(ibmPrice, applePrice, googPrice);;
		}
	}

}
