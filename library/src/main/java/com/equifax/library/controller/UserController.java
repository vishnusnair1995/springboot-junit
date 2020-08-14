package com.equifax.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.equifax.library.model.User;
import com.equifax.library.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method=RequestMethod.POST,value="/addUser/{userId}")
	public User addUser(@RequestBody User user,@PathVariable(name="userId") int userId) {
		if(userService.authenticateUser(userId)) {
			return userService.addUser(user);
		}else {
			return null;
		}
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(name="id")  int userId,@RequestHeader("Verifyuser") int Verifyuser) {
		return userService.deleteUser(userId,Verifyuser);
		
	}
	
	
}

