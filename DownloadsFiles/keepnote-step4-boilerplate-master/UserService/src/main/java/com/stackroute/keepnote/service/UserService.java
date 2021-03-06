package com.stackroute.keepnote.service;

import java.util.List;

import com.stackroute.keepnote.exceptions.UserAlreadyExistsException;
import com.stackroute.keepnote.exceptions.UserNotFoundException;
import com.stackroute.keepnote.model.User;

public interface UserService {

//	/*
//	 * Should not modify this interface. You have to implement these methods in
//	 * corresponding Impl classes
//	 */

	 void registerUser(User user) throws UserAlreadyExistsException;

	    User updateUser(String userId,User user) throws UserNotFoundException;

	    boolean deleteUser(String userId) throws UserNotFoundException;


	    List<User> getUserById(String userId) throws UserNotFoundException;
}
