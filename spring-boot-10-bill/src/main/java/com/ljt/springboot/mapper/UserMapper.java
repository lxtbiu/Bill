package com.ljt.springboot.mapper;

import com.ljt.springboot.entities.User;

import java.util.List;

public interface UserMapper {

    User getUserByUsername(String username);

    List<User> getUsers(User user);

    User getUserById(Integer id);

    int addUser(User user);

    int deleteUserById(Integer id);

    int updateUser(User user);

}
