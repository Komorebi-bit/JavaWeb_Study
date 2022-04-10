package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servlet.CookieServlet", value = "/servlet.CookieServlet")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();

        Cookie cookieUsername = new Cookie("username",request.getParameter("username"));
        Cookie cookiePassword = new Cookie("password",request.getParameter("password"));

        if(request.getParameter("SaveCookie") != null && request.getParameter("SaveCookie").equals("YES")){
            cookieUsername.setMaxAge(7*24*60*60);
            cookiePassword.setMaxAge(7*24*60*60);
        }else{
            cookieUsername.setMaxAge(0);
            cookiePassword.setMaxAge(0);
        }

        response.addCookie(cookieUsername);
        response.addCookie(cookiePassword);

        out.println("Welcome"+request.getParameter("username"));
    }
}
