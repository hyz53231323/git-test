package com.example.mapper;

import com.example.entity.book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface bookMapper {
    @Select("select * from book where id =#{id}")
    book sellectBookById(int id);
}
