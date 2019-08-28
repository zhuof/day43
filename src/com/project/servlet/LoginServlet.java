package com.project.servlet;


import com.project.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          request.setCharacterEncoding("UTF-8");
          response.setCharacterEncoding("UTF-8");
//          response.setContentType("text/html;charset=utf-8");
//response.setContentType("utf-8");

          String username=request.getParameter("username");
          String password=request.getParameter("password");


        LoginService service=new LoginService();
        int flag=service.login(username,password);
        if (flag==0){
            String msg = "正在审核,请等待.";
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }else if (flag==1){
            request.getRequestDispatcher("success.jsp").forward(request,response);

        }else if (flag==2){
            String msg = "审核未通过,重新注册.";
            request.setAttribute("msg",msg);
            request.getRequestDispatcher("index.jsp").forward(request,response);

        }else if (flag==3){
            request.setAttribute("msg","用户名或密码错误");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

    }

}
