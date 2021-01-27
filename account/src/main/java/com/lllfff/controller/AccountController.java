package com.lllfff.controller;

import com.lllfff.entity.Account;
import com.lllfff.mapper.AdminMapper;
import com.lllfff.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;

    @GetMapping("/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type){
        Object object = null;
        switch (type){
            case "user":
                object = userMapper.login(username, password);
                break;
            case "admin":
                object = adminMapper.login(username, password);
                break;
        }
        return object;
    }
}
