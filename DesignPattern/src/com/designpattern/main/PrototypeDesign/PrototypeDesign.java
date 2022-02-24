package com.designpattern.main.PrototypeDesign;

import java.util.ArrayList;
import java.util.List;

class Vehicle implements Cloneable{

	private List<String> vehicleList;
	public Vehicle() {
		this.vehicleList = new  ArrayList<>();
	}
	public Vehicle(List<String> list) {
		this.vehicleList = list;
	}
	public void insertData() {
		vehicleList.add("Honda");
		vehicleList.add("BMW");
		vehicleList.add("Tesla");
		vehicleList.add("Tata");
		vehicleList.add("Audi");
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		List<String> tempList = new ArrayList<>();
		for(String each:this.vehicleList) {
			tempList.add(each);
		}
		return new Vehicle(tempList);
	}
	public List<String> getVehicleList() {
		return vehicleList;
	}
}
public class PrototypeDesign {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Vehicle a = new Vehicle();
		a.insertData();
		Vehicle b = (Vehicle) a.clone();
		List<String> list = b.getVehicleList();
		list.add("Maruti");
		System.out.println(b.getVehicleList());
		System.out.println(a.getVehicleList());
	}

}
