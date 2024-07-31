package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.entity.Student;
import org.example.mapper.TestMapper;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        try(SqlSession session = factory.openSession(true)){
            TestMapper mapper =  session.getMapper(TestMapper.class);
            System.out.println(mapper.getStudentbysid(1213));
        }
    }
}