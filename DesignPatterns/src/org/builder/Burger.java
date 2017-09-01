package org.builder;

public abstract class Burger implements Item{

	@Override
	public Packaging getPackaging() {
		
		return new Wrapper();
	}

	
}
