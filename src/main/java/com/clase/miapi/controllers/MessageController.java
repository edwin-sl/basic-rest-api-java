package com.clase.miapi.controllers;

import com.clase.miapi.mq.Consumer;
import com.clase.miapi.mq.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by edwin on May, 2019
 */
@RestController
@RequestMapping("/messages")
public class MessageController {

    @GetMapping
    public boolean consume(){
        new Consumer();
        return true;
    }

    @PostMapping
    public boolean publish(){
        new Producer();
        return true;
    }
}
