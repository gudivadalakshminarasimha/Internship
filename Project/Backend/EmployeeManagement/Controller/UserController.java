package com.example.EmployeeManagement.Controller;

import com.example.EmployeeManagement.Dto.User;
import com.example.EmployeeManagement.Service.UserService;
import com.example.EmployeeManagement.Exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET})
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        return userService.verify(user);
    }

    @GetMapping("/profile")
    public User getUserProfile(@RequestHeader("Authorization") String token) {
        String username = userService.getUsernameFromToken(token);
        User user = userService.getUserByUsername(username);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
        return user;
    }
}
