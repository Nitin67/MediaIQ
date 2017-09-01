package coding.designpattern.decorator;

public class PlainPizza implements Pizza{

	@Override
	public String getDescription() {	
		return "Thin dough";
	}

	@Override
	public double getCost() {
		System.out.println("Cost of thin dough: " + 4);
		return 4;
	}

	
}
