package com.project.afterFail.controllers;

import com.project.afterFail.entities.User;
import com.project.afterFail.repos.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId){
        return userRepository.findById(userId).orElse(null);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setUserName(updatedUser.getUserName());
            foundUser.setUserName(updatedUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        }else{
            return null;
        }
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId){
        userRepository.deleteById(userId);
    }

}