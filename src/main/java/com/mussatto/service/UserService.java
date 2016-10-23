package com.mussatto.service;

import com.mussatto.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}