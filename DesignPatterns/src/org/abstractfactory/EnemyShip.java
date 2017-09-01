package org.abstractfactory;

public abstract class EnemyShip {

	private String name;
	private int damage;
	private double speed;
	private ESEngine engine;
	private ESWeapon esWeapon;
	
	public ESEngine getEngine() {
		return engine;
	}
	public void setEngine(ESEngine engine) {
		this.engine = engine;
	}
	public ESWeapon getEsWeapon() {
		return esWeapon;
	}
	public void setEsWeapon(ESWeapon esWeapon) {
		this.esWeapon = esWeapon;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
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
