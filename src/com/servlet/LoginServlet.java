package servlet;

import dao.UserDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String user = request.getParameter("username");
        String pwd = request.getParameter("password");
        //out.println(user+","+pwd);

        UserDao dao = new UserDao();
        boolean result = dao.checkUser(user,pwd);

        if(result){
            request.getSession().setAttribute("username",user);
            //转发
            // request.getRequestDispatcher("/BookListServlet").forward(request,response);
            response.sendRedirect(request.getContextPath()+"/FindUserByPageServlet");
        }else{
            // String s = "http://localhost:9527?user=哈哈哈";
            // s = URLEncoder.encode(s,"utf-8");
            // System.out.println(s);
            request.getSession().setAttribute("msg",0);
            response.sendRedirect("/login.jsp");
        }
    }
}
