package com.lllfff.mapper;

import com.lllfff.entity.User;

public interface UserMapper {
    public User login(String username, String password);
}
