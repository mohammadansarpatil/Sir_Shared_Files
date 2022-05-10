package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.EmployeeDao;
import com.model.Employees;

@RestController
public class AppController {
	
	@Autowired
	private EmployeeDao employeeDAO;
	
	@GetMapping("/loadall")
	public Employees loadAll() {
		return employeeDAO.getAllEmpList();
	}
	

}
