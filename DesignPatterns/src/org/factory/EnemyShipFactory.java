package org.factory;

public class EnemyShipFactory {

	public static EnemyShip getEnemyShip(String shipType){
		
		if(shipType.equalsIgnoreCase("Rocket")){
			return new RocketEnemyShip();
		}
		else if(shipType.equalsIgnoreCase("Rocket")){
			return new UFOEnemyShip();
		}
		else{
			throw new IllegalArgumentException("Ship type not defined");
		}
	}
}
