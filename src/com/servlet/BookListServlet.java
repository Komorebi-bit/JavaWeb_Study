package servlet;

import dao.BookDao;
import entity.Book;
import entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Komorebi
 * @date 2022.05.05.20:03
 */
@WebServlet(name = "BookListServlet", value = "/BookListServlet")
public class BookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        //访问数据层，获取数据库中图书信息
        BookDao dao = new BookDao();
        List<Book> bookList = dao.findAll();
        //判断列表是否有数据,如果有数据进入booklist.jsp,否则当前页面打印相关提示信息
        if(!bookList.isEmpty()){
            request.setAttribute("booklist",bookList);
            // User user = (User) request.getAttribute("username");
            // request.setAttribute("username",user);
            request.getRequestDispatcher("/booklist.jsp").forward(request,response);
        }else{
            out.println("未查询到任何图书信息");
        }

    }
}
