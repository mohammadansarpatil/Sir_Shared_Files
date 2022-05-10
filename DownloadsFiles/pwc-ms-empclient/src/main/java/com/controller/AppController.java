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


import com.service.AppService;

@RestController
@RequestMapping("/mainapp")
public class AppController {
	
	@Autowired
	private AppService service;
	
	
	//@RequestMapping(value="/welcome", method= RequestMethod.GET)
/*	@GetMapping("/loadusersfromapporm")
	public String loadUsers(){
			return service.callApp();
	}*/
	
	@GetMapping("/loadusersfromappmvc")
	public String loadUsers1(){
			return service.callApp1();
	}
	@GetMapping("/loadusersfromappmvc/{loc}")
	public String loadUsers2(@PathVariable("loc")String loc){
			return service.callApp2(loc);
	}
	
	@GetMapping("/loaddept")
	public String loadDept1(){
			return service.callAppDept1();
	}
	@GetMapping("/loaddept/{loc}")
	public String loadDept2(@PathVariable("loc")String loc){
			return service.callAppDept2(loc);
	}
	
}