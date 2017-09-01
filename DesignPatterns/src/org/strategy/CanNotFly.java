package org.strategy;

public class CanNotFly implements Fly{

	@Override
	public String fly() {
		return "Can't fly";
	}

}
