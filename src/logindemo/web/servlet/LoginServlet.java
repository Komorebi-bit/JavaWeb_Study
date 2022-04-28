package web.servlet;

import dao.UserDao;
import domain.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils2.BeanUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author Komorebi
 * @date 2022.04.28.21:18
 */
@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        /*String username = request.getParameter("username");
        String password = request.getParameter("password");

        User loginUser = new User();
        loginUser.setUsername(username);
        loginUser.setPassword(password);*/

        /**
         * BeanUtils:标准的Java类
         *  1.要求
         *      类必须被public修饰
         *      必须提供无参构造器
         *      成员变量必须使用private修饰
         *      提供公共的setter和getter方法
         *  2.功能：封装对象
         * 2.方法
         *      setproperty()
         *      getProperty()
         *      populate()
         */

        //获取所有请求参数
        Map<String, String[]> map = request.getParameterMap();
        User loginUser = new User();
        //使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDao userDao = new UserDao();
        User user = userDao.login(loginUser);

        if(user != null){
            request.setAttribute("user",user);
            request.getRequestDispatcher("/SuccessServlet").forward(request,response);
        }
        if(user == null){
            request.getRequestDispatcher("/FailServlet").forward(request,response);
        }
    }
}
