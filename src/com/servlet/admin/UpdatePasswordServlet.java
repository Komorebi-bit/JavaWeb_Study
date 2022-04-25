package com.servlet.admin;

import com.db.Dao;
import com.utils.DBOper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Komorebi
 * @date 2022.04.19.20:44
 */
@WebServlet(name = "com.servlet.admin.UpdatePasswordServlet", value = "/com.servlet.admin.UpdatePasswordServlet")
public class UpdatePasswordServlet extends HttpServlet {
    public UpdatePasswordServlet(){super();}

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
        String newpwd = request.getParameter("newpassword");

        Dao conn = new Dao();

        String sql = "UPDATE userdetail SET userpass=? WHERE username=? and userpass=?";
        int count = conn.executeUpdate(sql, new String[]{newpwd,user,pwd});
        if(count == 1){
            out.println("修改成功");
        }else{
            out.println("修改失败");
        }
    }
}
