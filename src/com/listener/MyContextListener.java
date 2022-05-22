package listener;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Komorebi
 * @since 2022.04.06.9:39
 *
 * 需要在web.xml配置！！！
 */

public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent argo){
        System.out.println("webService start");
    }

    @Override
    public void contextDestroyed(ServletContextEvent argo){
        System.out.println("webService stop");
        try{
            while(DriverManager.getDrivers().hasMoreElements()){
                DriverManager.deregisterDriver(DriverManager.getDrivers().nextElement());
            }
            System.out.println("jdbc Driver close");
            AbandonedConnectionCleanupThread.checkedShutdown();
            System.out.println("clean thread success");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
