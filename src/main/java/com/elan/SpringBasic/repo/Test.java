package com.elan.SpringBasic.repo;

public class Test {
	
	
	public static void main(String[] args) {
		
		EmployeeDaoImp ep = new EmployeeDaoImp();
		//ep.createEmployee(4, "venkat");
		System.out.println(ep.getEmployeeName(3));
	}

}
