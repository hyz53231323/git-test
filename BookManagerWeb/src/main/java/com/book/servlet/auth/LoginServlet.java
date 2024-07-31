package com.book.servlet.auth;

import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;
import com.book.utils.ThymeLeafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
UserService service;
    @Override
    public void init() throws ServletException {
        service = new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = utf-8");
        Context context = new Context();
        processLoginFailure(req, context);
        if(req.getSession().getAttribute("user")!=null){
            resp.sendRedirect("index");
        }
        ThymeLeafUtil.process("login.html",context, resp.getWriter());

    }

    private void processLoginFailure(HttpServletRequest req, Context context) {
        // 检查会话中是否存在"Login-failure"属性
        if (req.getSession().getAttribute("Login-failure") != null) {
            // 设置上下文中的失败变量
            context.setVariable("failure", true);
            // 从会话中移除"Login-failure"属性
            req.getSession().removeAttribute("Login-failure");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        if(service.auth(username,password,req.getSession())){
            resp.sendRedirect("index");
        }else {
            req.getSession().setAttribute("Login-failure",new Object());
            this.doGet(req,resp);
        }
    }
}
