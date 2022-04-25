package com.servlet.admin;

import com.db.Dao;
import com.utils.DBOper;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Komorebi
 * @date 2022.04.19.21:20
 */
@WebServlet(name = "com.servlet.admin.DeleteUserServlet", value = "/com.servlet.admin.DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String user = request.getParameter("name");
        String pwd = request.getParameter("password");

        Dao conn = new Dao();

        String sql = "delete from userdetail where username=? and userpass=?";
        int count = conn.executeUpdate(sql,new String[]{user,pwd});
        if(count==1){
            out.println("删除成功");
        }else{
            out.println("删除失败");
        }
    }
}
