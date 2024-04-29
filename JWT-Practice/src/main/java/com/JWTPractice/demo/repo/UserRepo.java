package com.JWTPractice.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.JWTPractice.demo.Entity.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	 Optional<User> findByName(String userName);

}
