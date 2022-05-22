package servlet;

import entity.Book;
import entity.PageBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.UserService;
import service.impl.UserServiceImpl;

import java.io.IOException;

/**
 * @author Komorebi
 * @date 2022.05.19.17:55
 */
@WebServlet(name="FindUserByPageServlet",value="/FindUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        doPost(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String currentPage = request.getParameter("currentPage");
        String rows = request.getParameter("rows");

        if(currentPage == null | "".equals(currentPage)){
            currentPage="1";
        }
        if(rows == null || "".equals(rows)){
            rows="8";
        }

        UserService service = new UserServiceImpl();
        PageBean<Book> pb = service.findUserByPage(currentPage,rows);

        request.getSession().setAttribute("pb",pb);
        //request.getRequestDispatcher("/booklist.jsp").forward(request,response);
        response.sendRedirect("/booklist.jsp");
    }
}
