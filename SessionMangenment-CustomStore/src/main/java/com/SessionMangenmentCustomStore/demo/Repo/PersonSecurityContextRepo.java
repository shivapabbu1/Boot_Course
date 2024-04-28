package com.SessionMangenmentCustomStore.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SessionMangenmentCustomStore.demo.entity.Person;

public interface PersonSecurityContextRepo extends JpaRepository<Person, Integer> {
	
	    Person findBySessionId(String sessionId);
	    boolean existsBySessionId(String sessionId);
	    
	
	    
}



