package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.entity.UserEntity;
import com.repository.UserRepository;


@Controller
public class UserController {
	
	@Autowired
	UserRepository userrepo;
	
	@GetMapping("/newuser")
	public String userlogin() {
		return "NewUser";
	}
	
	@PostMapping("/loginuser")
	public String postMethodName(UserEntity user) {
		System.out.println(user.getEmail());
		userrepo.save(user);
		
		return "NewUser";
	}
	
}
