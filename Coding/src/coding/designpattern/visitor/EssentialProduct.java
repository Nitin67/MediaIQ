package coding.designpattern.visitor;

public class EssentialProduct implements Visitable{

	double price;
	public EssentialProduct(double price) {
		this.price = price;
		
	}
	
	@Override
	public void accept(Visitor visitor) {
		System.out.println("Price of" + this.getClass() +" before tax: "+ this.price );
		System.out.println("Price of" + this.getClass() +" after tax: "+ visitor.visit(this));
	}

}
