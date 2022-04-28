package test;

import dao.UserDao;
import domain.User;
import org.junit.Test;

/**
 * @author Komorebi
 * @date 2022.04.28.21:00
 */
public class UserDaoTest {
    @Test
    public void testLogin(){
        UserDao dao = new UserDao();
        User loginUser = new User();
        loginUser.setUsername("ko");
        loginUser.setPassword("12311");
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
