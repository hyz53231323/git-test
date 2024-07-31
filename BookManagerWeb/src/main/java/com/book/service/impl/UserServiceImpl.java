package com.book.service.impl;

import com.book.entity.User;
import com.book.dao.Usermapper;
import com.book.service.UserService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpSession;

public class UserServiceImpl implements UserService {

    @Override
    public boolean auth(String username, String passsword, HttpSession session) {
        try(SqlSession sqlSession = MybatisUtil.getSession( )){
            Usermapper mapper = sqlSession.getMapper(Usermapper.class);
            User user = mapper.getuser(username,passsword);
            if(user == null)
                return false;
            session.setAttribute("user",user);
            return true;

        }
    }
}
