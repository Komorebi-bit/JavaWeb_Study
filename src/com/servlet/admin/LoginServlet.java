package com.servlet.admin;

import com.db.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "com.servlet.admin.servlet.LoginServlet", value = "/com.servlet.admin.servlet.LoginServlet")
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
        String pw = request.getParameter("password");

        String server = "localhost";
        String dbname = "haier";
        String dbuser = "root";
        String dbpw = "10086";


        Dao dao = new Dao();
        try {
            dao.getConn(server,dbname,dbuser,dbpw);

            System.out.println("数据库连接成功");

            String sql = "select * from userdetail where username=? and userpass=?";

            boolean bool = dao.executeQuery(sql,user,pw);

            if(bool){
                out.println("登录成功");
            }else{
                out.println("登录失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            dao.closeAll();
        }
    }
}