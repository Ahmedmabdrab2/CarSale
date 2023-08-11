package com.example.carSale.service;

import com.example.carSale.entity.User;

public interface UserService {
    User getUser(Integer id);
    User getUser(String username);
    User saveUsername(User user);
}
