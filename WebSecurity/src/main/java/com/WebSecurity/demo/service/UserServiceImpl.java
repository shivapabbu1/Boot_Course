package com.WebSecurity.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.WebSecurity.demo.Repo.UserRepo;
import com.WebSecurity.demo.entity.User;

@Service

public class UserServiceImpl implements UserDetailsService{
    @Autowired
    private  UserRepo repo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repo.findByusername(username);

		if (user == null) {
		  throw new UsernameNotFoundException("User not found: " + username);
	           
		} else {
			
			 return new CustomDetail(user);
		}
	}
    

	public String addUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		repo.save(user);
		return "User added successfully";
	}


        




	
}
