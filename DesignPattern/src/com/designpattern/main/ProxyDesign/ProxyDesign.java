package com.designpattern.main.ProxyDesign;

interface DatabaseExecuter{
	public void excuteDatabase(String query) throws Exception;
}
class DatabaseExecuterImpl implements DatabaseExecuter{

	@Override
	public void excuteDatabase(String query) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Going to execute query "+query);	
	}	
}
class DatabaseExecuterProxy implements DatabaseExecuter{

	boolean ifAdmin;
	DatabaseExecuter databaseExecuter;
	
	public DatabaseExecuterProxy(String name,String password) {
		if(name.equals("Admin") && password.equals("Admin@123")) {
			ifAdmin = true;
			databaseExecuter = new DatabaseExecuterImpl();
		}
	}
	@Override
	public void excuteDatabase(String query) throws Exception {
		// TODO Auto-generated method stub
		if(ifAdmin) {
			databaseExecuter.excuteDatabase(query);
		}
		else {
			if(query.equals("DELETE")) {
				throw new Exception("DELETE not allowed");
			}
			else {
				databaseExecuter.excuteDatabase(query);
			}
		}
		
	}
	
}
public class ProxyDesign {
	public static void main(String args[]) {
		DatabaseExecuterProxy databaseExecuterProxy = new DatabaseExecuterProxy("NonAdmin", "Admin@123");
		try {
			databaseExecuterProxy.excuteDatabase("DELETE");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
