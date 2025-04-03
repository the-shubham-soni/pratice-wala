package com.example.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.model.UserDetails;
import com.example.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public void sendUser(UserDetails userDetails) {
		userRepository.save(userDetails);
	}
	
	public List<UserDetails> getUser() {
		return userRepository.findAll();
	}
	
	public UserDetails update(int id,  UserDetails userDetails) {
		
		Optional<UserDetails> exist=userRepository.findById(id);
		
		if(exist.isPresent()) {
			UserDetails u=exist.get();
			if(userDetails.getName()!=null) {
				u.setName(userDetails.getName());
			}
			
			else if(userDetails.getDescription()!=null) {
				u.setDescription(userDetails.getDescription());
			}
			
			return userRepository.save(u);
		}
		else {
			throw new RuntimeException("ye wali id nahi mili bhai 😔" + id);
		} 
	}
}
