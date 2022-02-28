package com.designpattern.main.BuilderDesign;

class Vehicle{
	private String engine;
	private int wheel;
	private int airbags;
	public String getEngine() {
		return engine;
	}
	public int getWheel() {
		return wheel;
	}
	
	public int getAirbags() {
		return airbags;
	}
	private Vehicle(VehicleBuilder builder) {
		this.engine = builder.engine;
		this.wheel = builder.wheel;
		this.airbags = builder.airbags;
	}
	public static class VehicleBuilder{
		private String engine;
		private int wheel;
		private int airbags;
		public VehicleBuilder(String engine,int wheel) {
			this.engine = engine;
			this.wheel = wheel;
		}
		public VehicleBuilder setAirbags(int airbags) {
			this.airbags = airbags;
			return this;
		}
		public Vehicle build() {
			return new Vehicle(this);
		}
	}
}
public class BuilderDesign {

	public static void main(String args[]) {
		Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
		System.out.println(car.getEngine()+" "+car.getAirbags());
		Vehicle bike = new Vehicle.VehicleBuilder("800cc", 2).build();
		System.out.println(bike.getEngine());
	}
}
