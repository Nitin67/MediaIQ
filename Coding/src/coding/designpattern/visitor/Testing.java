package coding.designpattern.visitor;

public class Testing {

	public static void main(String[] args) {
		TaxVisitor taxVisitor = new TaxVisitor();
		TaxHolidayVisitor taxHolidayVisitor = new TaxHolidayVisitor();
		Liquor liquor = new Liquor(453);
		Tobbaco tobbaco= new Tobbaco(23);
		EssentialProduct essentialProduct = new EssentialProduct(25);
		liquor.accept(taxVisitor);
		liquor.accept(taxHolidayVisitor);
		tobbaco.accept(taxVisitor);
		tobbaco.accept(taxHolidayVisitor);
		essentialProduct.accept(taxVisitor);
		essentialProduct.accept(taxHolidayVisitor);
	}
}
