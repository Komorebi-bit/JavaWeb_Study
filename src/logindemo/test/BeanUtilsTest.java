package test;

import domain.User;
import org.apache.commons.beanutils2.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Komorebi
 * @date 2022.04.28.22:07
 */
public class BeanUtilsTest {
    @Test
    public void test(){
        User user = new User();
        String username="";
        try {
            BeanUtils.setProperty(user,"username","zhangsan");
            username = BeanUtils.getProperty(user, "username");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        System.out.println(username);
    }
}
