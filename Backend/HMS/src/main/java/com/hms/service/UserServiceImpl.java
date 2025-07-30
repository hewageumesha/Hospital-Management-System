package com.hms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hms.dto.UserDTO;
import com.hms.entity.User;
import com.hms.exception.HMSException;
import com.hms.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(UserDTO userDTO) throws HMSException{
        Optional <User> optional = userRepository.findByEmail(userDTO.getEmail());
        if(optional.isPresent()) {
            throw new HMSException("USER_ALREADY_EXISTS");
        }
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(userDTO.toEntity());
    }

    @Override
    public UserDTO loginUser(UserDTO userDTO) throws HMSException{
        User user = userRepository.findByEmail(userDTO.getEmail()).orElseThrow(() -> new HMSException("USER_NOT_FOUND"));
        if(!passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
            throw new HMSException("INVALID_CREDENTIALS");
        }
        user.setPassword(null);
        return user.toDTO();
    }

    @Override
    public UserDTO getUserById(Long id) throws HMSException{
        return userRepository.findById(id).orElseThrow(() -> new HMSException("USER_NOT_FOUND")).toDTO();
    }

    @Override
    public void updateUser(UserDTO userDTO) throws HMSException{
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public UserDTO getUser(String email) throws HMSException{
        return userRepository.findByEmail(email).orElseThrow(() -> new HMSException("USER_NOT_FOUND")).toDTO();
    }
    
}
