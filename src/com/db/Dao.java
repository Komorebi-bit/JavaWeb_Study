package com.db;

import com.utils.DBOper;

import java.sql.*;

/**
 * @author Komorebi
 * @since 2022.04.05.20:40
 */

public class Dao {
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/haier?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    String user = "root";
    String pwd = "10086";
    Connection conn = null;
    PreparedStatement pstt = null;
    ResultSet rs = null;

    //连接数据库
    public Connection getConn() {
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
        return conn;
    }

    //查询
    public ResultSet executeQuery(String sql,String user,String pwd){
        try {
            conn=getConn();
            pstt = conn.prepareStatement(sql);
            pstt.setString(1,user);
            pstt.setString(2,pwd);
            rs = pstt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //更新
    public int executeUpdate(String sql, Object[] params){
        try{
            conn=getConn();
            pstt = conn.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
                pstt.setObject(i+1,params[i]);
            }
            int count = pstt.executeUpdate();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally{
            closeAll();
        }
        return 0;
    }

    //释放资源
    public void closeAll() {
        try {
            if (rs != null) {rs.close();}
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstt != null) pstt.close();
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
}
