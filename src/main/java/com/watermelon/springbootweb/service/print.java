package com.watermelon.springbootweb.service;

import org.springframework.stereotype.Component;

@Component
public class print {


    public void printhello(){
        System.out.println("hello world");
    }

    public void printdate(){
        System.out.println(System.nanoTime());
    }


}
