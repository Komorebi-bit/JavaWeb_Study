package web.servlet;

import domain.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

/**
 * @author Komorebi
 * @date 2022.04.28.21:34
 */
@WebServlet(name = "SuccessServlet", value = "/SuccessServlet")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        User user = (User)request.getAttribute("user");
        if(user!=null){
            response.getWriter().write("登录成功！"+user.getUsername()+"欢迎您");
        }
    }
}
