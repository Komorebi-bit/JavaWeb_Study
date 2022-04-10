package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author Komorebi
 * @since 2022.03.22.20:00
 */

@WebServlet("/redirectServlet")
public class RedirectServlet extends HttpServlet{

    public RedirectServlet(){super();}

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        doPost(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("t","测试");

        // response.sendRedirect(request.getContextPath()+"/myservlet");

        RequestDispatcher rd = request.getRequestDispatcher("/myservlet");
        rd.forward(request,response);

    }

}
