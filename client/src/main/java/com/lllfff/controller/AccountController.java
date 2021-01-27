package com.lllfff.controller;

import com.lllfff.entity.Account;
import com.lllfff.entity.Admin;
import com.lllfff.entity.User;
import com.lllfff.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountFeign accountFeign;
    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session){
        Object object = accountFeign.login(username, password,type);
        LinkedHashMap<String,Object> hashMap=(LinkedHashMap<String, Object>) object;
       String result=null;
        String idstr=null;
        long id=0L;
       if (object==null){
           result="login";
       }else{
           switch (type){
               case "user":
                 User user=new User();
                  idstr= hashMap.get("id")+"";
                  id=Long.parseLong(idstr);
                 String nikname=(String) hashMap.get("nickname");
                 user.setId(id);
                 user.setNickname(nikname);
                 session.setAttribute("user",user);
                     result="index";
                   break;
               case "admin":
                   Admin admin=new Admin();
                    idstr= hashMap.get("id")+"";
                    id=Long.parseLong(idstr);
                   String username2=(String) hashMap.get("username");
                   admin.setId(id);
                   admin.setUsername(username2);
                   session.setAttribute("admin",admin);
                   result="main";
                   break;
           }
       }
        return "redirect:/menu/redirect/"+result;


    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }


}
