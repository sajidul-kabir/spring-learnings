package com.sajid.security.controllers;

import com.sajid.security.entities.UserEntity;
import com.sajid.security.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.Authenticator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserEntity user){
        System.out.println("sss");
return userService.adduser(user);
    }

    @GetMapping("/rest")
    public String getRest(){
        return "rest";
    }
    @PostMapping("/login-rest")
    public ResponseEntity<Void> login(@RequestBody UserEntity user) {
        // Create an authentication token with the provided username and password
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        try {
            // Authenticate the user
            Authentication authentication =  authenticationManager.authenticate(authenticationToken);

            // Set the authentication object to the SecurityContext
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // If authentication is successful, return OK status
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            // Authentication failed, return unauthorized status
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
