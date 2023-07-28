package com.service.UserService.service;

import com.service.UserService.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);

    String deleteUser(String userId);

    User updateUser(User user);
}
