package com.elan.SpringBasic.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.elan.SpringBasic.repo.EmployeeDao;
import com.elan.SpringBasic.repo.EmployeeDaoImp;


@Controller
@RequestMapping("/getemployee")
public class ControllerImp {
	
	@Autowired
	EmployeeDao ep;
	
	void controllerMethod(){
		
		//EmployeeDaoImp ep = new EmployeeDaoImp();
		ep.createEmployee(5, "sunny");
		
		
	}
	
	@RequestMapping(value="getemployeename", method = RequestMethod.GET)
	public String getEmployeName(@RequestParam int id  ){
		return ep.getEmployeeName(id);
	}

	
	
}
