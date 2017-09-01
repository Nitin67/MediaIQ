package coding.designpattern.visitor;

public class TaxHolidayVisitor implements Visitor{


	@Override
	public double visit(Liquor liqour) {
		return (liqour.price + (liqour.price * .15));
	}

	@Override
	public double visit(Tobbaco tobbaco) {
		
		return (tobbaco.price + (tobbaco.price * .16) );
	}

	@Override
	public double visit(EssentialProduct prod) {
		
		return (prod.price);
	}

}
