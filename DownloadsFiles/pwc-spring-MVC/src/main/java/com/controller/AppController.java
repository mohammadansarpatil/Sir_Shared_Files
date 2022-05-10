package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Login;
import com.model.Registration;
import com.service.AppService;

@RestController
@RequestMapping("/mainapp")
public class AppController {
	
	@Autowired
	private AppService service;
	
	//@RequestMapping(value="/welcome", method= RequestMethod.GET)
	@GetMapping("/loadusers")
	public List<Registration> sayHello(){
			List<Registration> lst = service.loadAll();
			return lst;
	}

	//@RequestMapping(value="/login", method= RequestMethod.POST)
	@PostMapping("/login")
	public String login(@RequestBody Login login) {
		if(service.loginValid(login )) {
			return "Login Success";
		}
		return "Login Failure";
	}
	
	//@RequestMapping(value="/register", method= RequestMethod.POST)
	@PostMapping("/register")
	public String register(@RequestBody Registration registeration) {
		registeration.getUserName();
		registeration.getPassword();
		registeration.getCity();
		registeration.getEmail();
		service.addUser(registeration);
		return "Register Success";
	}
	
	@GetMapping("/finduser/{uname}")
	public String findUser(@PathVariable("uname")String name) {
		if(service.findUser(name))
			return name + " Found";
		else
			return name + " Not Found";
	}
	
	@DeleteMapping("/deleteuser/{uname}")
	public String deleteUser(@PathVariable("uname")String name) {
		if(service.deleteUser(name))
			return name + " Found and Deleted";
		else
			return name + " Not Found";
	}
	
	@PutMapping("/updateuser/{uname}")
	public String updateUser(@RequestBody Registration reg , @PathVariable("uname")String name) {
		if(service.updateUser(reg, name)) {
			return name + " Updated";
		}
		else {
			return name + " Failed to update";
		}
		
	}
	
}
