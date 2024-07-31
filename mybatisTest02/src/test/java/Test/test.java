package Test;

import entity.Book;
import mapper.bookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    public static void main(String[] args) throws IOException {
        //指定核心配置文件路径
        String resource = "mybatis.xml";
        //获取配置文件的输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //加载配置文件，创建工厂类
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过工厂类来获取一个会话
        SqlSession session = sqlSessionFactory.openSession();

        bookMapper mapper = session.getMapper(bookMapper.class);

        Book book1 = new Book(12,"活着","余华",22.4);
        mapper.insertBook(book1);

        List list = mapper.selectAllBook();
        for(int i =0;i<=list.size()-1;i++){
            System.out.println(list.get(i));
        }

        Book b = mapper.selectOneBook("红高粱");
        System.out.println(b);

        session.commit();//事务操作:提交
        session.close();
    }

}
