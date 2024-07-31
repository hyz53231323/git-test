package com.example;

import entity.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationcontext.xml");
        Object b = context.getBean("book");
        System.out.println(b);


    }
}