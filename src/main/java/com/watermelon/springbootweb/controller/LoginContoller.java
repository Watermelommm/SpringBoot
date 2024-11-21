package com.watermelon.springbootweb.controller;

import com.watermelon.springbootweb.Pojo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginContoller {


//    @RequestMapping(value="loginController" )
    @PostMapping("loginController")
    public ResponseEntity<User> login(@RequestBody User user){
        System.out.println(user.getUsername());
        user.setName(user.getUsername());
        if("xiwang".equals(user.getUsername())){
            return  ResponseEntity.ok(user);
        }
        return ResponseEntity.status(404).build();
//        return user;
    }



}
