package com.servlet.admin;

import com.db.Dao;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "com.servlet.admin.LoginServlet", value = "/com.servlet.admin.LoginServlet")
public class LoginServlet extends HttpServlet {

    public LoginServlet(){super();}

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("loginName");
        String pwd = request.getParameter("password");

        /*ServletContext context = this.getServletContext();
        String server = context.getInitParameter("server");
        String dbname = context.getInitParameter("dbname");
        String user = context.getInitParameter("user");
        String pwd = context.getInitParameter("pwd");*/

        Dao conn = new Dao();
        try {
            boolean result = false;
            String sql = "select * from userdetail where username=? and userpass=?";
            ResultSet rs = conn.executeQuery(sql, user, pwd);
            if(rs.next()){
                out.println("登陆成功");
            }else{
                out.println("登录失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            conn.closeAll();
        }
    }
}