package com.example.service.impl;

import com.example.entity.book;
import com.example.mapper.bookMapper;
import com.example.service.bookService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class bookServiceImpl implements bookService {
    @Resource
    bookMapper bookmapper;
    public book selectBook() {
       return bookmapper.sellectBookById(1);
    }
}
