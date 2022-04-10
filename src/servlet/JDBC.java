package servlet;

import java.sql.*;
import java.util.Scanner;

public class JDBC {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&&useSSL=true";
        String username = "root";
        String password = "10086";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("数据库连接成功！");

            conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

