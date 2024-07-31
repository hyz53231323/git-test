package userMapper;

import entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface mapper {

    @Select("select *  from user where username = #{username} and pwd = #{pwd}")
    User getuser(@Param("username")String username, @Param("pwd")String pwd);

}
