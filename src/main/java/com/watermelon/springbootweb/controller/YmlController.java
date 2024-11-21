package com.watermelon.springbootweb.controller;

import com.watermelon.springbootweb.Pojo.YmlUser;
import com.watermelon.springbootweb.service.loginService;
import com.watermelon.springbootweb.service.print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YmlController {

    @Autowired
    private YmlUser user;

    @Autowired
    loginService loginService;

    @PostMapping("ymlController")
    public ResponseEntity<YmlUser> ymlPost(@RequestBody YmlUser ymlUser){

        System.out.println("Autowired : " + user);
        System.out.println("postUser :"+ ymlUser.getUsername());



        loginService.login();

        return ResponseEntity.ok(user);
    }

}
