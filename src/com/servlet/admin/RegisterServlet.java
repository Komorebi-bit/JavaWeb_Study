package com.servlet.admin;

import com.db.Dao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "com.servlet.admin.RegisterServlet", value = "/com.servlet.admin.RegisterServlet")
public class RegisterServlet extends HttpServlet {

    public RegisterServlet(){super();}

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("name");
        String pwd = request.getParameter("password");

        Dao conn = new Dao();

        String sql = "insert into userdetail values(?,?,0,now(),0)";
        int count = conn.executeUpdate(sql, new String[]{user,pwd});
        if(count == 1){
            out.println("注册成功");
        }else{
            out.println("注册失败");
        }
    }
}
