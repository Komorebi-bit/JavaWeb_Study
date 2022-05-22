package dao;

import entity.User;
import utils.DBUtilPre;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Komorebi
 * @date 2022.04.18.19:45
 */
public class UserDao {
    //数据访问层，包含所有和用户相关的数据操作
    //实例化一个驱动连接对象
    DBUtilPre conn = new DBUtilPre();
    //登录操作用户名密码验证方法
    public boolean checkUser(String username, String password){
        boolean result = false;
        String sql = "select * from user_t where u_name=? and u_password=?";
        String[] params = {username,password};
        ResultSet rs = conn.executeQueryRS(sql,params);
        User user = null;
        try {
            while(rs.next()) {
                user = new User();
                user.setName(rs.getString("u_name"));
                user.setPwd(rs.getString("u_password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            conn.closeAll();
        }
        if(user != null){
            result=true;
        }
        return result;
    }
}
