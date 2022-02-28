package com.designpattern.main.FacadeDesign;

import java.sql.Driver;

class Firefox{
	public static Driver getFirefoxDriver() {
		return null;
	}
	public static void generateHtMLReport(String test,Driver driver) {
		System.out.println("Generating HTML Report");
	}
	public static void generateJUnitReport(String test,Driver driver) {
		System.out.println("Generating JUnit Report ");
	}
}
class Chrome{
	public static Driver getChromeDriver() {
		return null;
	}
	public static void generateHtMLReport(String test,Driver driver) {
		System.out.println("Generating HTML Report");
	}
	public static void generateJUnitReport(String test,Driver driver) {
		System.out.println("Generating JUnit Report ");
	}
}
class FacadeHelper{
	public static void generateReports(String explorer,String report,String test) {
		Driver driver  = null;
		switch(explorer) {
		case "firefox":
			driver = Firefox.getFirefoxDriver();
			switch(report) {
			case "html":
				Firefox.generateHtMLReport(test, driver);
				break;
			case "JUnit":
				Firefox.generateJUnitReport(test, driver);
				break;
			default:
				System.out.println("Wrong Input");	
			}
		    break;
		case "chrome":
			driver = Chrome.getChromeDriver();
			switch(report){
			case "html":
				Chrome.generateHtMLReport(test, driver);
				break;
			case "JUnit":
				Chrome.generateJUnitReport(test, driver);
				break;
			default:
				System.out.println("Wrong Input");	
			}
			break;
		default:
			System.out.println("Wrong Input");
			}
		}
	}
public class FacadeDesign {

	public static void main(String arr[]) {
		String test = "";
		FacadeHelper.generateReports("firefox", "html", test);
		FacadeHelper.generateReports("chrome", "JUnit", test);

	}
}
