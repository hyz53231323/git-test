package com.example.controller;

import com.example.entity.Book;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class bookController {
    @Autowired
    private BookService bookService;
    @RequestMapping("/selectAllBook")
    @ResponseBody
    public String selectAllBook(){
        List list = bookService.selectAllBook();
        String b="";
        for(int i=0;i<=list.size()-1;i++){
            Book book =(Book)list.get(i);
            b+=book.getAuthor();
            b+=" ";
            b+=book.getName();
        }
        return b;
    }
}
