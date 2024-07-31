package com.example;

import mapper.bookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String resource = "mybatis.xml";
        //获取配置文件的输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //加载配置文件，创建工厂类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂类来获取一个会话
        SqlSession session = sqlSessionFactory.openSession();
        //接口的引用指向实现类
        bookMapper mapper = session.getMapper(bookMapper.class);
//        List list = mapper.selectAllBook();
//        for(int i =0;i<= list.size()-1;i++){
//            System.out.println(list.get(i));
//        }
//        mapper.deleteBookById(1);
//        List list1 = mapper.selectAllBook();
//        for(int i =0;i<= list1.size()-1;i++){
//            System.out.println(list1.get(i));
//        }
        mapper.updateBook(2,11);
        List list1 = mapper.selectAllBook();
        for(int i =0;i<= list1.size()-1;i++){
            System.out.println(list1.get(i));
        }

        session.commit();//事务操作:提交
        session.close();
    }
}