package cn.study.datasource.druid;

import cn.study.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Komorebi
 * @date 2022.04.09.22:09
 *
 * 使用utils.JDBCUtils类
 */
public class DruidDemo2 {
    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getconnection();
            String sql = "select * from phone where name=?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1,"Redmi");
            rs = pstm.executeQuery();
            while(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(rs.getInt(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            JDBCUtils.close(rs,pstm,conn);
        }
    }
}
