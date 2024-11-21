package com.watermelon.springbootweb.controller;

import com.watermelon.springbootweb.Pojo.User;
import com.watermelon.springbootweb.service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("demo")
public class HelloController {




    @RequestMapping("helloController/{name}")
    public String hello(@ModelAttribute("user") User user , Model model, @PathVariable String name){


        System.out.println(user);

        System.out.println("name= "+ name);

        model.addAttribute("username", user);

        return  "hello";
    }

}
