package coding.designpattern.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StockGrabber implements Subject{

	private int ibmPrice;
	private int applePrice;
	
	
	public int getIbmPrice() {
		return ibmPrice;
	}
	public void setIbmPrice(int ibmPrice) {
		this.ibmPrice = ibmPrice;
		notifyObserver();
	}
	public int getApplePrice() {
		return applePrice;
	}
	public void setApplePrice(int applePrice) {
		this.applePrice = applePrice;
		notifyObserver();
	}
	public List<Observer> getList() {
		return list;
	}
	public void setList(List<Observer> list) {
		this.list = list;
	}
	List<Observer> list = new ArrayList<Observer>();
	public StockGrabber() {
	}
	@Override
	public void registerObserver(Observer observer) {
		list.add(observer);
	}
	@Override
	public void unregisterObserver(Observer observer) {
		if(list.contains(observer)){
			list.remove(observer);
		}else{
			throw new IllegalArgumentException();
		}
		
	}
	@Override
	public void notifyObserver() {
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Observer observer = (Observer) iterator.next();
			observer.update(ibmPrice, applePrice);
		}
		
	}
	
}
