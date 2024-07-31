package com.example.service.impl;

import com.example.mapper.Bookmapper;
import com.example.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class bookServiceimpl implements bookService {
    @Autowired
    private Bookmapper bookmapper;
    public List findAllBook() {

        return bookmapper.selectAllBook();
    }
}


