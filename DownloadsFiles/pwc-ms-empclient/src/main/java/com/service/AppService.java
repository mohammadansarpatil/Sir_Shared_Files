package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class AppService {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	/*public String callApp() {
		String response  = restTemplate.exchange("http://localhost:8090/mainapp/loadusers", 
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				}).getBody();
		return response;
	}*/
	
	public String callApp1() {
		String response  = restTemplate.exchange("http://emp-service/loademp", 
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				}).getBody();
		return response;
	}
	
	public String callApp2(String loc) {
		String response  = restTemplate.exchange("http://localhost:8050/myemploademp/{loc}", 
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				}, loc).getBody();
		return response;
	}
	
	public String callAppDept1() {
		String response  = restTemplate.exchange("http://emp-dept/loaddept", 
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				}).getBody();
		return response;
	}
	
	public String callAppDept2(String proj) {
		String response  = restTemplate.exchange("http://emp-dept/loaddept/{proj}", 
				HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
				}, proj).getBody();
		return response;
	}
	
}