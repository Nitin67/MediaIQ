package coding.designpattern.decorator;

public class TomatoDecorator extends TopingDecorator{

	public TomatoDecorator(Pizza pizza) {
		super(pizza);
	}
	
	public String getDescription(){
		return tempPizza.getDescription() + ", Tomato";
	}
	
	public double getCost(){
		return tempPizza.getCost() + .5;
	}
	
}
