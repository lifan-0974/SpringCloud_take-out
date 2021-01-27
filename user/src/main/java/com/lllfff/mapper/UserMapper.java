package com.lllfff.mapper;

import com.lllfff.entity.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAll(int index, int limit);
    public int count();
    public void save(User user);
    public void deleteById(long id);
}
