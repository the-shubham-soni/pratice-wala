package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.UserDetails;
import com.example.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public String addUser(@RequestBody UserDetails userDetails){
		 userService.sendUser(userDetails);
		 return "User Added Succesfully!";
	}
	
	@GetMapping("/get")
	public List<UserDetails> getUsers() {
		return userService.getUser();
	}
	
	@PutMapping("/update")
	public String updateUser(@RequestParam int id, @RequestBody UserDetails userDetails) {
		userService.update(id, userDetails);
		return "User updated Succesfully 😘";
	}
}
