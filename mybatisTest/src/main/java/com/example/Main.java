package com.example;

import entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        //指定核心配置文件路径
        String resource = "mybatis.xml";
        //获取配置文件的输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //加载配置文件，创建工厂类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
       //通过工厂类来获取一个会话
        SqlSession session = sqlSessionFactory.openSession();
        List list = session.selectList("a.selectAllBook");
        for (int i =0;i<= list.size()-1;i++){
            Book b = (Book) list.get(i);
            System.out.println(b.toString());
        }
        session.close();
    }
}