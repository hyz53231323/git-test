package com.example.controller;

import com.example.entity.Book;
import com.example.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class bookController {
    @Autowired
    private bookService bookService;

    @RequestMapping(value = "/findAllBook",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String findAllBook(){
        List list = bookService.findAllBook();
        String book =" ";
        for (int i=0;i<= list.size()-1;i++){
           Book b =(Book)list.get(i);
           book = book + b.getAuthor();
           book= book +b.getName();
        }
        return  book;
    }
}
