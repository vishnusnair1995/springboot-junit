package com.equifax.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.equifax.library.model.User;
import com.equifax.library.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	public String deleteUser(int userId,int verifyUser) {
		User authUser=userRepo.findById(verifyUser).orElse(null);
		if(authUser.getUserRole().equalsIgnoreCase("Admin")) {
		  User user=userRepo.findById(userId).orElse(null);
		  String name=user.getUserName();
		  userRepo.delete(user);
		  return name +" deleted";
		}else {
			return "No access";
		}
	}
	
	public boolean authenticateUser(int userId) {
	    User user=userRepo.findById(userId).orElse(null);
		if(user.getUserRole().equalsIgnoreCase("Admin")) {
		return true;
	}else {
		return false;
	}
  }
	
	
}