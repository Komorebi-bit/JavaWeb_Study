package cn.study.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Komorebi
 * @date 2022.04.09.21:37
 */
public class JDBCUtils {
    private static DataSource ds;

    static{
        try{
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getconnection() throws SQLException {
        return ds.getConnection();
    }

    //释放资源
    public static void close(Statement statement, Connection connection){
        // if(statement!=null){
        //     try {
        //         statement.close();
        //     } catch (SQLException e) {
        //         e.printStackTrace();
        //     }
        // }
        // if(connection!=null){
        //     try {
        //         connection.close();//归还
        //     } catch (SQLException e) {
        //         e.printStackTrace();
        //     }
        // }
        close(null,statement,connection);
    }

    public static void close(ResultSet resultSet, Statement statement, Connection connection){
        if(resultSet !=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();//归还
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //获取连接池方法
    public static DataSource getDataSource(){
        return ds;
    }

}
