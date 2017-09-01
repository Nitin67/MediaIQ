package org.chainofresponsibility;

public class AddNumer implements Chain{

	private Chain nextChain;
	public AddNumer() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int calculate(int x, int y) {
		
		return x + y;
	}
	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
		
	}

}
