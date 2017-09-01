package org.chainofresponsibility;

public interface Chain {

	int calculate(int x, int y);
	
	void setNextChain(Chain nextChain);
}
