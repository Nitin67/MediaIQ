package org.strategy;

public class Animal {
	
	private String name;
	private double weight;
	private double height;
	private int age;
	private String color;
	private double speed;
	private String sound;
	//Fly is defined as separate interface so that it can br changed at run time
	private Fly fly;
	
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	public Fly getFly() {
		return fly;
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
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String tryToFly() {
		return fly.fly();
	}
	public void setFly(Fly fly) {
		this.fly = fly;
	}
	
}
