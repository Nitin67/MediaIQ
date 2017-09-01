package coding.designpattern.visitor;

public class Liquor implements Visitable{

	public Liquor(double price) {
		this.price = price;
	}
	double price;
	
	@Override
	public void accept(Visitor visitor) {
		System.out.println("Price of" + this.getClass() +" before tax: "+ this.price );
		System.out.println("Price of" + this.getClass() +" after tax: "+ visitor.visit(this));
	}

}
