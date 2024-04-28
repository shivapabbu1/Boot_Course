package com.SessionMangenmentCustomStore.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SessionMangenmentCustomStore.demo.entity.PersonInfo;




	 public interface PersonInfoRepo extends JpaRepository<PersonInfo, Integer> {
			
		 PersonInfo findByUsername(String username);
		    

		    
		}


