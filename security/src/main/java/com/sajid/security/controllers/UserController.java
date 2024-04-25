package com.sajid.security.controllers;

import com.sajid.security.entities.UserEntity;
import com.sajid.security.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/")
    public String home(){
        System.out.println(userService.getRolesOfAnUser("sajid"));

        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public void dologin()
    {
        System.out.println("loginnn");
//        return "login";
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('admin')")
    public String admin(){
        return "admin";
    }
    @GetMapping("/new-user")
    public String newUser(){
        return "new-user";
    }
    @PostMapping("/new-user")
    public String createNewUser(UserEntity user) {
       userService.adduser(user);
        // Logic to create new user here
        // You can handle the creation of the new user in your service layer
        // For example: userService.createUser(user);

        // Redirect to home page after creating user
        return "redirect:/";
    }


}
