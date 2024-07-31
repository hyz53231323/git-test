package com.example.service.impl;

import com.example.mapper.bookMapper;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private bookMapper bookMapper;
    @Override
    public List selectAllBook() {
        return bookMapper.selectAllBook();
    }
}
