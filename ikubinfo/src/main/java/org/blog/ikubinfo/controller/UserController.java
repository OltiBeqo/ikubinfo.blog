package org.blog.ikubinfo.controller;

import org.blog.ikubinfo.dto.UserDTO;
import org.blog.ikubinfo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @GetMapping
    private ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.ok(userService.getUsers());
    }
    @GetMapping("/{id}")
    private ResponseEntity<UserDTO> getUserById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getUserById(id));
    }
    @PostMapping
    private ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.createUser(userDTO));
    }
    @PutMapping("/{id}")
    private ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.updateUserById(id, userDTO));
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
