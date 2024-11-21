package com.watermelon.springbootweb.service;

import com.fasterxml.jackson.databind.BeanProperty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class loginService {

    @Autowired
    print print;

    public loginService(com.watermelon.springbootweb.service.print print) {
        this.print = print;
    }

    public void login(){
        print.printdate();
    }
}
