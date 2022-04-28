package dao;

import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

/**
 * @author Komorebi
 * @date 2022.04.28.20:34
 */
public class UserDao {
    //声明JdbcTemplate对象公用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param loginUser 只有用户名和密码
     * @return user 包含用户全部数据
     */
    public User login(User loginUser){
        try{
            String sql = "select * from user where username=? and password=?";
            User user = template.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(),loginUser.getPassword());
            return user;
        }catch(DataAccessException e){
            e.printStackTrace();
            return null;
        }
    }
}
