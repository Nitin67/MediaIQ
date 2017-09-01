package coding.designpattern.observer;

public class StockObserver implements Observer{

	private int ibmPrice;
	private int applePrice;
	
	@Override
	public void update(int ibmPrice, int applePrice) {
		this.ibmPrice = ibmPrice;
		this.applePrice = applePrice;
	}

}
