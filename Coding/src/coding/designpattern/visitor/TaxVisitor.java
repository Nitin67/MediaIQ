package coding.designpattern.visitor;

public class TaxVisitor implements Visitor{

	@Override
	public double visit(Liquor liqour) {
		return (liqour.price + (liqour.price * .25));
	}

	@Override
	public double visit(Tobbaco tobbaco) {
		
		return (tobbaco.price + (tobbaco.price * .32) );
	}

	@Override
	public double visit(EssentialProduct prod) {
		
		return (prod.price);
	}

}
