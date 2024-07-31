package book.manage.sql;

import book.manage.mapper.Bookmapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.function.Consumer;

public class SqlUtil {
    private SqlUtil(){}
    private static final SqlSessionFactory  factory;

    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void doSqlwork(Consumer<Bookmapper> consumer){    //第一次感受到了函数式接口的妙用
      try(SqlSession session = factory.openSession(true)){
          Bookmapper bookmapper = session.getMapper(Bookmapper.class);
          consumer.accept(bookmapper);
      }
    }

}
