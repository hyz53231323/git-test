package org.example.servlet;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@MultipartConfig
@WebServlet(value = "/file")
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("image/png");
        OutputStream outputStream = resp.getOutputStream();
        InputStream inputStream = Resources.getResourceAsStream("loginbg.png");
        IOUtils.copy(inputStream,outputStream);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(FileOutputStream stream = new FileOutputStream("C:\\Users\\幻影诸\\Desktop\\2222.png")){
            Part part = req.getPart("test-file");
            IOUtils.copy(part.getInputStream(), stream);
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().write("文件上传成功！");
        }
    }
}
