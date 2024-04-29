package com.JWTPractice.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.JWTPractice.demo.Entity.User;
import com.JWTPractice.demo.repo.UserRepo;



@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=repo.findByName(username).orElse(null);
		if(null !=user) {
			return new UserInfoDetails(user);
		} else {
			
			throw new UsernameNotFoundException("User not found: " + username);
		}
	}
	public String regUser(User user) {
		 
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			repo.save(user);
			return "User added successfully";
		}
	
	public List<User> getAllUser() {
		return repo.findAll();
	}

	public User getUser(Integer id) {
		return repo.findById(id).get();
	}
	
	

}
