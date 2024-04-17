package com.EMS_MDB.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EMS_MDB.demo.Entity.MongoUser;
import com.EMS_MDB.demo.repo.UserRepo;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public MongoUser addUser(MongoUser user) {
		return userRepo.save(user);
	}

	public List<MongoUser> getAllUsers() {
		return userRepo.findAll();
	}

	public Optional<MongoUser> getUserById(String id) {
		return userRepo.findById(id);
	}

	public MongoUser updateUserById(String id, MongoUser newUser) {
		Optional<MongoUser> optionalUser = userRepo.findById(id);
		if (optionalUser.isPresent()) {
			MongoUser existingUser = optionalUser.get();
			existingUser.setName(newUser.getName());
			existingUser.setSurname(newUser.getSurname());
			existingUser.setEmail(newUser.getEmail());
			return userRepo.save(existingUser);
		} else {
			return null;
		}
	}

	public void deleteUserById(String id) {
		userRepo.deleteById(id);
	}
}
