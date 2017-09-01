package org.factory;

public class UFOEnemyShip extends EnemyShip{

	@Override
	public void setDamage(int damage) {
		super.setDamageForShip(damage);
	}

	public UFOEnemyShip() {
		setName("UFO enemy ship");
		setDamage(20);
	}
	
}
