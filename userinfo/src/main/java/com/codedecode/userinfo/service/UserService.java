package com.codedecode.userinfo.service;

import com.codedecode.userinfo.dto.UserDTO;
import com.codedecode.userinfo.entity.User;
import com.codedecode.userinfo.mapper.UserMapper;
import com.codedecode.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public UserDTO addUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.mapUserDTOToUser(userDTO);
        User userCreated = userRepo.save(user);
        return UserMapper.INSTANCE.mapUserToUserDTO(userCreated);
    }
}
