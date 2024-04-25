package com.sajid.security.services;

import com.sajid.security.dto.UserRoleDto;
import com.sajid.security.entities.UserEntity;
import com.sajid.security.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

     public List<UserRoleDto> getRolesOfAnUser(String username){
        return userRepository.findRolesofAnUserByUsername(username);
    }
    public String adduser(UserEntity user){
         user.setPassword(passwordEncoder.encode(user.getPassword()));
         userRepository.save(user);
         return "USER ADDED";
    }
}
