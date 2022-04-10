package servlet;

import jakarta.servlet.http.*;
import jakarta.servlet.*;

import java.io.IOException;

public class ServletLife extends HttpServlet {
    //构造方法
    public ServletLife(){super();}

    //初始化方法
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("初始化时，init()方法被调用");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("处理请求时，doGet()方法被调用");
    }
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        System.out.println("处理请求时，doPost()方法被调用");
    }

    //释放资源
    @Override
    public void destroy(){
        super.destroy();
        System.out.println("释放资源时，destroy()方法被调用。");
    }
}
