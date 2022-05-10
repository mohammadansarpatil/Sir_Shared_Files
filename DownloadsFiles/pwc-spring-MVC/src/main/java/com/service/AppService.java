package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Login;
import com.model.Registration;

@Service
public class AppService {
	
	List<Registration> lst = new ArrayList<Registration>();
	
	public boolean loginValid(Login login) {
		
		for(Registration reg : lst)
		if(login.getUserName().equals(reg.getUserName()) && login.getPassword().equals(reg.getPassword())) {
			return true;
		}
		return false;		
	}
	
	public void addUser(Registration registration) {
		lst.add(registration);
		System.out.println(lst);
		
	}
	
	public List<Registration> loadAll(){
		return lst;
	}
	
	public boolean findUser(String name) {
		for (Registration rs : lst) {
			if(rs.getUserName().equalsIgnoreCase(name)) {
				System.out.println(rs.getEmail());
				return true;
			}
		}
		return  false;
	}
	
	
	public boolean deleteUser(String name) {
		for (Registration rs : lst) {
			if(rs.getUserName().equalsIgnoreCase(name)) {
				lst.remove(rs);
				return true;
			}
		}
		return  false;
	}
	
	public boolean updateUser(Registration reg , String name) {
		for (Registration rs : lst) {
			if(rs.getUserName().equals(name)) {
				rs.setCity(reg.getCity());
				rs.setEmail(reg.getEmail());
				rs.setPassword(reg.getPassword());
				rs.setUserName(reg.getUserName());
				return true;
			}
	}
		return false;

}
}
