package com.elan.SpringBasic.repo;

import com.elan.SpringBasic.domain.Employee;

public interface EmployeeDao {

	
	
	public Employee createEmployee(int id, String name);
	
	public  String getEmployeeName(int id);
}
