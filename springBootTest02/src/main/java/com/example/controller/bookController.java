package com.example.controller;

import com.example.entity.book;
import com.example.mapper.bookMapper;
import com.example.service.impl.bookServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class bookController {
    @Resource
    bookServiceImpl b;

    @RequestMapping("/selectBook")
    @ResponseBody
    public book selectBook(){

        return b.selectBook();
    }
}
