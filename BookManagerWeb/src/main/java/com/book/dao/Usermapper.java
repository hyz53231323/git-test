package com.book.dao;

import com.book.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface Usermapper {
    @Select("select * from admin where username = #{username} and password = #{password}")
    User getuser(@Param("username")String username, @Param("password") String password);
}
