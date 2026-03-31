package com.example.library_management_system.Controller;

import com.example.library_management_system.Models.User;
import com.example.library_management_system.Services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class usersController {

    private final UserServices userServices;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userServices.createUser(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        return userServices.getUsers();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        return userServices.deleteUser(id);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id , @RequestBody User user) {
        return userServices.updateUser(id , user);
    }
}
