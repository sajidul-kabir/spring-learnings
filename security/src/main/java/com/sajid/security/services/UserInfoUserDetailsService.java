package com.sajid.security.services;

import com.sajid.security.config.UserDeatilsConfig;
import com.sajid.security.entities.UserEntity;
import com.sajid.security.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private  UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Optional<UserEntity> userEntity=userRepository.findByUsername(username);

       return userEntity.map(UserDeatilsConfig::new).orElseThrow(()->new UsernameNotFoundException("User not found"));
    }
}
