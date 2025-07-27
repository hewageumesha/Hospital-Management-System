package com.hms.service;

import com.hms.dto.UserDTO;
import com.hms.exception.HMSException;

public interface UserService{
    public void registerUser(UserDTO userDTO) throws HMSException;
    public UserDTO loginUser(UserDTO userDTO) throws HMSException;
    public UserDTO getUserById(Long id) throws HMSException;
    public void updateUser(UserDTO userDTO) throws HMSException;
}
