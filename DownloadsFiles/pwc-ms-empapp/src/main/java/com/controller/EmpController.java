package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.model.*;

@RestController
public class EmpController {
	
	private static Map<String, List<Employee>> empDB = new HashMap<String , List<Employee>>();
	static List<Employee> lst = new ArrayList<Employee>();

	static{
		empDB = new HashMap<String, List<Employee>>();
		Employee emp = new Employee("Ansar" , "Mumbai");
		lst.add(emp);
		emp = new Employee("Rahul", "Pune");
		lst.add(emp);
		empDB.put("india", lst);
		
		lst = new ArrayList<Employee>();
		emp= new Employee("Jacob", "Malay");
		lst.add(emp);
		emp= new Employee("Mark", "Singapore");
		lst.add(emp);
		empDB.put("asia", lst);
		
	}
	
	@GetMapping("/loademp/{location}")
	public List<Employee> loadEmp(@PathVariable("location")String location){
		List<Employee> emplist = empDB.get(location);
		
		if(emplist==null) {
			emplist = new ArrayList<Employee>();
			Employee emp = new Employee("NA" , "NOT FOUND");
			emplist.add(emp);
			
		}
		return emplist;

	}
	
	@GetMapping("/loademp")
		public List<Employee> loadEmp1(){
			return lst;
		}
		
	}
	
	

