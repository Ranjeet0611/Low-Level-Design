package com.designpattern.main.factorydesign;

abstract class Vehicle{
	public abstract int getWheel();

	@Override
	public String toString() {
		return "Vehicle [getWheel()=" + getWheel() + "]";
	}
	
}
class Car extends Vehicle{

	int wheel;
	Car(int wheel){
		this.wheel = wheel;
	}
	@Override
	public int getWheel() {
		// TODO Auto-generated method stub
		return this.wheel;
	}
	
}
class Bike extends Vehicle{

	int wheel;
	Bike(int wheel){
		this.wheel = wheel;
	}
	@Override
	public int getWheel() {
		// TODO Auto-generated method stub
		return this.wheel;
	}
	
}
class VehicleFactory{
	public static Vehicle getInstance(String type,int wheel) {
		if(type.equals("car")) {
			return new Car(wheel);
		}
		if(type.equals("bike")) {
			return new Bike(wheel);
		}
		return null;
	}
}
public class FactoryDesign {
	public static void main(String args[]) {
		Vehicle vehicle = VehicleFactory.getInstance("car", 4);
		System.out.println(vehicle);
	}
}
