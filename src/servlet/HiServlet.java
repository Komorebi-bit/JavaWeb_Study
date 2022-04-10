package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;


public class HiServlet extends HttpServlet {
    int number=0;

    public HiServlet(){}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=GBK");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body>");

        synchronized(this){
            number++;
            out.println("<h1>Hello World</h1>");
            out.println("<h2>你好</h2>");

        }
        out.println("</body>");
        out.println("</html>");
    }
}
