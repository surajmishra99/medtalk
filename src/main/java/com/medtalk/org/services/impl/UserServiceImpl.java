package com.medtalk.org.services.impl;

import com.medtalk.org.entity.User;
import com.medtalk.org.payloads.UserDto;
import com.medtalk.org.repository.UserRepo;
import com.medtalk.org.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

import java.util.List;


public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto createUser(UserDto userDto){
        User user=this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        this.userRepo.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId){
//        User user = this.userRepo.findById(userId).orElseThrow((e-> new ResourceNotFoundException("user","id")));
        return null;
    }

    @Override
    public UserDto getUserById(Integer userId){
        return null;
    }

    @Override
    public List<UserDto> getAllUsers(){
        return null;
    }

    @Override
    public void deleteUser(Integer userId){
    }

    private User dtoToUser (UserDto userDto)
    {
        User user=new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setAbout(userDto.getAbout());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto userToDto (User user)
    {
        UserDto userDto=new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setEmail(user.getEmail());
        userDto.setAbout(user.getAbout());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

}
