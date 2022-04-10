package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "servlet.SecondServlet", value = "/s2")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Object obj1 = request.getAttribute("request_param");
        String request_param = null;
        if(obj1 != null){
            request_param = obj1.toString();
        }else{
            request_param = null;
        }

        HttpSession session = request.getSession();
        Object obj2 = session.getAttribute("session_param");
        String session_param = obj2.toString();
        if(obj2 != null){
            session_param = obj2.toString();
        }else{
            session_param = null;
        }

        //销毁session
        // session.invalidate();

        out.println("<html><body>");
        out.println("<h2>请求对象中的参数是："+request_param+"</h2>");
        out.println("<h2>Session对象中的参数是："+session_param+"</h2>");
        out.println("</body></html>");
    }
}
