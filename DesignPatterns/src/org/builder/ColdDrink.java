package org.builder;

public abstract class ColdDrink implements Item{


	@Override
	public Packaging getPackaging() {
		// TODO Auto-generated method stub
		return new Bottle();
	}

}
