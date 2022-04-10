package com.db;

import java.sql.*;

/**
 * @author Komorebi
 * @since 2022.04.05.20:40
 */

public class Dao {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    // 连接数据库
    public Connection getConn(String server, String dbname, String user, String pw)
            throws ClassNotFoundException, SQLException {
        String Driver = "com.mysql.cj.jdbc.Driver";
        String url =
                "jdbc:mysql://"
                        + server
                        + ":3306/"
                        + dbname
                        + "?useUnicode=true&characterEncodind=utf-8&useSSL=true";

        //String url = "jdbc:mysql://localhost:3306/haier?useUnicode=true&characterEncodind=utf-8&useSSL=true";

        Class.forName(Driver);
        conn = DriverManager.getConnection(url, user, pw);
        return conn;
    }

    // 释放资源
    public void closeAll() {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //验证用户登录信息
    public boolean executeQuery(String sql,String user,String pw){
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,user);
            pst.setString(2,pw);
            rs = pst.executeQuery();
            if(rs!=null && rs.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
