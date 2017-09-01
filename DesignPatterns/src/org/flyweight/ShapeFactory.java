package org.flyweight;

import java.util.HashMap;

public class ShapeFactory {

	String colors[] = {"Red", "Green", "Yelow", "Brown", "Black"};
	HashMap<String, Circle> map = new HashMap<>();
	public Circle getCircleByColor(String color){
		Circle circle = null;
		if(map.containsKey(color)){
			circle = map.get(color);
		}else{
			circle= new Circle(color);
		}
		circle.setX(getRandomXorY());
		circle.setY(getRandomXorY());
		circle.setRadius(getRandomXorY());
		return circle;
		
	} 
	String getRandomColor(){
		return colors[(int)Math.random()*colors.length];
	}
	
	int getRandomXorY(){
		return (int)(Math.random()*100);
	}
}
