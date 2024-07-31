package com.example.controller;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class testControlller {
    @PostConstruct
    public void init(){
        log.info("我是Slf4j日志");
    }

}
