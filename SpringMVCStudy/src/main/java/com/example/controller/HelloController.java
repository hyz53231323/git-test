package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/")   //直接填写访问路径
    public ModelAndView hello(){
        return new ModelAndView("index");  //返回ModelAndView对象，这里填入了视图的名称
        //返回后会经过视图解析器进行处理
    }
}