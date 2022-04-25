package com.utils;

import java.sql.*;
import java.util.*;

/**
 * @author Komorebi
 * @date 2022.04.19.19:32
 */
public class DBOper {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URLSTR = "jdbc:mysql://localhost:3306/haier?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    private static final String USERNAME = "root";
    private static final String USERPASSWORD = "10086";
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("驱动连接失败");
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URLSTR, USERNAME, USERPASSWORD);
        } catch (SQLException e) {
            System.out.println("连接失败");
            System.out.println(e.getMessage());
        }
        return connection;
    }
    public int executeDelete(String sql,Object[] params) {
        int affectedLine = 0;
        try {
            connection = this.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 4; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            affectedLine = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeAll();
        }
        return affectedLine;
    }

    public int executeUpdate(String sql, Object[] params) {
        int affectedLine = 0;
        try {
            connection = this.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            affectedLine = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeAll();
        }
        return affectedLine;
    }


    public ResultSet executeQueryRS(String sql, Object...params) {
        try {
            connection = this.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            resultSet = preparedStatement.executeQuery();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultSet;
    }


    public List<Object> excuteQuery(String sql, Object[] params)
    {
        ResultSet rs = executeQueryRS(sql,params);
        ResultSetMetaData rsmd = null;
        int columnCount = 0;
        try {
            rsmd = rs.getMetaData();
            columnCount = rsmd.getColumnCount();
        } catch (SQLException e1) {
            System.out.println(e1.getMessage());
        }

        List<Object> list = new ArrayList<Object>();

        try {
            while(rs.next()) {
                Map<String, Object> map = new HashMap<String, Object>();
                for(int i = 1; i <= columnCount; i++) {
                    map.put(rsmd.getColumnLabel(i), rs.getObject(i));
                }
                list.add(map);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeAll();
        }

        return list;
    }

    public void closeAll() {

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
