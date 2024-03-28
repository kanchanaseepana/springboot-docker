package com.nagarro.dockersample.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.dockersample.Entity.User;
import com.nagarro.dockersample.Respository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  
  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

 
  @GetMapping("/users/{id}")
  public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId)
      throws NoSuchElementException {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new NoSuchElementException("User not found on :: " + userId));
    return ResponseEntity.ok().body(user);
  }

  /**
   * Create user user.
   *
   * @param user the user
   * @return the user
   */
  @PostMapping("/users")
  public User createUser(@RequestBody User user) {
    return userRepository.save(user);
  }

  
  @PutMapping("/users/{id}")
  public ResponseEntity<User> updateUser(
      @PathVariable(value = "id") Long userId,@RequestBody User userDetails)
      throws NoSuchElementException {

    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));

    user.setEmail(userDetails.getEmail());
    user.setLastName(userDetails.getLastName());
    user.setFirstName(userDetails.getFirstName());
//    user.setUpdatedAt(new Date());
    final User updatedUser = userRepository.save(user);
    return ResponseEntity.ok(updatedUser);
  }

 
  @DeleteMapping("/user/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));

    userRepository.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }
}
