package coding.designpattern.decorator;

abstract class TopingDecorator implements Pizza{

	protected Pizza tempPizza;
	
	public TopingDecorator(Pizza pizza) {
		this.tempPizza = pizza;
	}
	
	@Override
	public String getDescription() {
		
		return tempPizza.getDescription();
	}

	@Override
	public double getCost() {
		return tempPizza.getCost();
	}

}
