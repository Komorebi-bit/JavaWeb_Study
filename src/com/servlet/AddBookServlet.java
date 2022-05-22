package servlet;

import dao.BookDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Komorebi
 * @date 2022.05.16.19:29
 */
@WebServlet(name = "AddBookServlet", value = "/AddBookServlet")
public class AddBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String b_name = request.getParameter("bookname");
        String author = request.getParameter("author");
        String price = (String)request.getParameter("price");
        //System.out.println(b_name+author+price);
        BookDao dao = new BookDao();
        boolean  result = false;
        if(request.getSession().getAttribute("username")!=null){
             result = dao.addBook(b_name,author,price);
            if(result){
                out.println("新增成功，3秒后自动返回列表页面");
                response.setHeader("refresh","3;url="+request.getContextPath()+"/FindUserByPageServlet");
            }else{
                out.println("新增失败，即将回到新增页面");
                response.setHeader("refresh","1;url="+request.getContextPath()+"/addbook.jsp");
            }
        }else{
            out.println("已注销，请重新登录");
            response.setHeader("refresh","2;url="+request.getContextPath()+"/login.jsp");
        }

    }
}
