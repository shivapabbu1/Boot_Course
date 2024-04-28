package com.SessionMangenmentCustomStore.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SessionMangenmentCustomStore.demo.Repo.PersonInfoRepo;

import com.SessionMangenmentCustomStore.demo.entity.PersonInfo;

@Service
public class CustomPersonUserDetail  implements UserDetailsService{
	
	@Autowired
	private PersonInfoRepo personInfoRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	PersonInfo personInfo=	personInfoRepo.findByUsername(username);
	if (personInfo == null) {
        throw new UsernameNotFoundException("User not found with username: " + username);
    }
    return org.springframework.security.core.userdetails.User.builder()
            .username(personInfo.getUsername())
            .password(personInfo.getPassword())
            .roles(personInfo.getRole())
            .build();
}
	
	

}
