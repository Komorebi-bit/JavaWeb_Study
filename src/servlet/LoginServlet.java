package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "com.servlet.LoginServlet", value = "/com.servlet.LoginServlet")
public class LoginServlet extends HttpServlet {

    public LoginServlet(){super();}

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // String user = request.getParameter("loginName");
        // String pass = request.getParameter("password");

        String cookieName = "username";
        String cookiePass = "password";

        Cookie[] cookies = request.getCookies();

        String username = "";
        String password = "";
        String isChecked = "";

        if(cookies != null && cookies.length >0){
            isChecked="checked";
            for(int i=0; i<cookies.length; i++){
                if(cookies[i].getName().equals(cookieName)){
                    username = cookies[i].getValue();
                }
                if(cookies[i].getName().equals(cookiePass)){
                    password = cookies[i].getValue();
                }
            }
        }



        out.println("<HTML>\n");
        out.println("<HEAD><TITLE>登录</TITLE></HEAD>\n");
        out.println("<BODY>\n");
        out.println("<center>\n");
        out.println("<form action='servlet.CookieServlet' method='post'>\n");
        out.println("姓名<input type='text' name='username' value='"+username+"'><br/>\n");
        out.println("密码<input type='password' name='password' value='"+password+"'><br/>\n");
        out.println("保存用户名和密码<input type='checkbox' name='SaveCookie' value='YES'"+isChecked+"><br/>\n");
        // out.println("保存用户名和密码<input type='checkbox' name='SaveCookie' value='NO'"+isChecked+"><br/>\n");
        out.println("<input type=\"submit\">\n");
        out.println("</form>\n");
        out.println("</center>\n");
        out.println("</BODY>\n");
        out.println("</HTML>\n");

    }
}
