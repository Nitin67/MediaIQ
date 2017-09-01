package coding.designpattern.visitor;

public class Tobbaco implements Visitable{
	
	double price;
	public Tobbaco(double price) {
		this.price = price;
	}

	@Override
	public void accept(Visitor visitor) {
		System.out.println("Price of" + this.getClass() +" before tax: "+ this.price );
		System.out.println("Price of" + this.getClass() +" after tax: "+ visitor.visit(this));		
	}

}
