package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servlet.FirstServlet", value = "/s1")
public class FirstServlet extends HttpServlet {
    public FirstServlet(){super();}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String s = request.getParameter("count");
        request.setAttribute("request_param",s);

        //获取当前session
        HttpSession session = request.getSession();
        //保存到session中
        session.setAttribute("session_param",s);
        out.println("<a href='s2'>下一页</a>");
    }
}
