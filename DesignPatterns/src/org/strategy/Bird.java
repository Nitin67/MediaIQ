package org.strategy;

public class Bird extends Animal{

	public Bird() {
		super();
		setSound("tweek");
		setFly(new ItFlys());
	}
	
	
}
