package com.designpattern.main.SingletonDesign;

class LazySingleton{
	private static LazySingleton instance;
	private LazySingleton() {
		
	}
	public static LazySingleton getInstance() {
		if(instance==null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}
class EagerSingleton{
	private static EagerSingleton instance = new EagerSingleton();
	private EagerSingleton() {
		
	}
	public static EagerSingleton getInstance() {
		return instance;
	}
}
public class SingletonDesign {

	public static void main(String args[]) {
		EagerSingleton instance = EagerSingleton.getInstance();
		EagerSingleton instance1 = EagerSingleton.getInstance();
		System.out.println(instance+" "+instance1);
	}
}
