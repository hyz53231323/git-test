package org.example.servlet;

import entity.User;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import userMapper.mapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(value = "/loggin" ,loadOnStartup = 1)
public class LoginServlet extends HttpServlet {


    SqlSessionFactory factory;
    @SneakyThrows
    @Override
    public void init() throws ServletException {
        factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //首先设置一下响应类型
        resp.setContentType("text/html;charset=UTF-8");
        //获取POST请求携带的表单数据
        Map<String, String[]> map = req.getParameterMap();
        //判断表单是否完整
        if (map.containsKey("username") && map.containsKey("password")) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            try(SqlSession session =factory.openSession(true)){
               mapper mapper = session.getMapper(mapper.class);
             User user =  mapper.getuser("Test","123");
             if(user != null){
              resp.sendRedirect("https://www.baidu.com");
             }
            }
            //权限校验（待完善）
        } else {
            resp.getWriter().write("错误，您的表单数据不完整！");
        }
    }
}