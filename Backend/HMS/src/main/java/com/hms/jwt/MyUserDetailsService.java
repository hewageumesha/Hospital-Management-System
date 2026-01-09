package com.hms.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hms.dto.UserDTO;
import com.hms.exception.HMSException;
import com.hms.service.UserService;

@Service 
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try{
            UserDTO userDTO = userService.getUser(email);
            return new CustomUserDetails(userDTO.getId(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getRole(), userDTO.getName(), userDTO.getEmail(), null);
        } catch(HMSException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
