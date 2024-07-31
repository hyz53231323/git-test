package com.tset;

import book.manage.mapper.Bookmapper;
import book.manage.sql.SqlUtil;
import org.junit.jupiter.api.Test;

public class MainTest {
@Test
    public void Test(){
    SqlUtil.doSqlwork(bookmapper -> {
        bookmapper.getBorrowList().forEach(System.out::println);
    });
}
}
