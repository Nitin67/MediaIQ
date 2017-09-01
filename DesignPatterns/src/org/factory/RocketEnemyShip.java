package org.factory;

public class RocketEnemyShip extends EnemyShip {

	@Override
	public void setDamage(int damage) {
		super.setDamageForShip(damage);
	}
	
	public RocketEnemyShip() {
		setName("Rocket Enemy Ship");
		setDamage(40);
	}

}
