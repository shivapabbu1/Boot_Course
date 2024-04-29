package com.WebSecurity.demo.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.WebSecurity.demo.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	 User findByusername(String userName);


}
