package cn.study.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * @author Komorebi
 * @date 2022.04.09.18:48
 */
public class C3P0Demo {
    public static void main(String[] args) throws SQLException {
        //1.创建数据库连接池对象
        //DataSource ds = new ComboPooledDataSource();
        //1.1获取DataSource,使用指定配置
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        for(int i = 1; i <= 11; i++) {
            //获取连接对象
            Connection conn = ds.getConnection();
            System.out.println(i+" "+conn);
            if(i==5)
                conn.close();//归还连接
        }
    }
}
