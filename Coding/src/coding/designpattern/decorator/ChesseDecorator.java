package coding.designpattern.decorator;

public class ChesseDecorator extends TopingDecorator{

	public ChesseDecorator(Pizza pizza) {
		super(pizza);
	}
	public String getDescription(){
		return tempPizza.getDescription() + ", chesse";
	}
	public double getCost(){
		return tempPizza.getCost() + .35;
	}
}
