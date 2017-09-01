package org.factory;

public abstract class EnemyShip {

	private String name;
	private int damage;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public abstract void setDamage(int damage);
	
	public void setDamageForShip(int damage){
		this.damage = damage;
	}
	public void followHeroShip(){
		System.out.println(getName() + "is following the enemy ship");
	}

	public void attact(){
		System.out.println(getName() + "attacked and damage is: " + getDamage());
	}
}
