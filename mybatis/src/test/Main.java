package test;


import mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(new FileInputStream("mybatis-config.xml"));
        try (SqlSession sqlSession = MybatisUtil.getSession(true)) {
            TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
            Student student = new Student();
            student.setName("小芳");
            student.setSex("女");
            System.out.println(testMapper.addStudent(student));


        }
    }
}