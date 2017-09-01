package coding.designpattern.chainofresponsibilty;

public interface Chain {

	void setNextChain(Chain chain);
	void calculate(Numbers numbers);
}
