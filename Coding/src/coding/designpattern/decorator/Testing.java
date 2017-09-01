package coding.designpattern.decorator;

public class Testing {
	public static void main(String[] args) {
		
		Pizza pizza= new TomatoDecorator(new ChesseDecorator(new PlainPizza()));
		System.out.println(pizza.getDescription());
		System.out.println(pizza.getCost());
	}
}
