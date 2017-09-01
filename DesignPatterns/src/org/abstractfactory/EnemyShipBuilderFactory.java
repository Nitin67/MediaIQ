package org.abstractfactory;

public abstract class EnemyShipBuilderFactory {

	protected abstract EnemyShip makeEnemyShip(String enemyShipType);
	
	public EnemyShip orderEnemyShip(String enemyShipType){
		EnemyShip enemyShip = this.makeEnemyShip(enemyShipType);
		
		return enemyShip;
		
	}
	
	
}
