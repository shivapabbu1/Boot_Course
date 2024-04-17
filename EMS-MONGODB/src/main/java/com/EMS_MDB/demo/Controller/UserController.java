package com.EMS_MDB.demo.Controller;

import com.EMS_MDB.demo.Entity.MongoUser;
import com.EMS_MDB.demo.Service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/createuser")
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser(@RequestBody MongoUser user) {
        userService.addUser(user);
        return "User created successfully";
    }

    @GetMapping("/getallusers")
    public List<MongoUser> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public MongoUser getUserById(@PathVariable("id") String id) {
        Optional<MongoUser> user = userService.getUserById(id);
        return user.orElse(null);
    }

    @PutMapping("/{id}")
    public MongoUser updateUserById(@PathVariable("id") String id, @RequestBody MongoUser newUser) {
    	MongoUser updatedUser = userService.updateUserById(id, newUser);
        if (updatedUser != null) {
            return updatedUser;
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") String id) {
        userService.deleteUserById(id);
        return "Deleted user successfully";
    }
}
