package coding.designpattern.visitor;

public interface Visitor {

	public double visit(Liquor liqour);
	public double visit(Tobbaco tobbaco);
	public double visit(EssentialProduct prod);
}
