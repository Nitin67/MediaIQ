package org.strategy;

public class Dog extends Animal{

	public void digHole(){
		System.out.println("Dig hole");
	}
	
	public Dog() {
		super();
		setFly(new CanNotFly());
	}
}
