package cn.study.jdbctemplate;

import cn.study.domain.Phone_copy;
import cn.study.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Map;
//import java.sql.Date;

/**
 * @author Komorebi
 * @date 2022.04.10.11:40
 *
 *
 * 调用JdbcTemplate的方法来完成CRUD的操作 * update():执行DML语句。增、删、改语句
 *     queryForMap():查询结果将结果集封装为map集合，将列名作为key，将值作为value 将这条记录封装为一个map集合
 *          注意：这个方法查询的结果集长度只能是1
 *     queryForList():查询结果将结果集封装为list集合
 *          注意：将每一条记录封装为一个Map集合，再将Map集合装载到List集合中
 *     query():查询结果，将结果封装为JavaBean对象 * query的参数：RowMapper
 *          一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装
 *              new BeanPropertyRowMapper<类型>(类型.class)
 *     * queryForObject：查询结果，将结果封装为对象 * 一般用于聚合函数的查询
 */

public class JdbcTemplateDemo2 {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    //查询name=mi的记录，将其封装为map集合
    @Test
    public void test1(){
        String sql = "select * from phone_copy where name=?";
        Map<String, Object> map = template.queryForMap(sql, "mi");
        //返回有且只有一个对象
        System.out.println(map);
    }

    //查询所有记录，将其封装为list集合
    @Test
    public void test2(){
        String sql = "select * from phone_copy";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap);
        }
    }

    //查询所有记录，将其封装为phone_copy对象的list集合
    @Test
    public void test3(){
        String sql = "select * from phone_copy";

        List<Phone_copy> list = template.query(sql, new RowMapper<Phone_copy>() {

            @Override
            public Phone_copy mapRow(ResultSet rs, int i) throws SQLException {
                Phone_copy phone = new Phone_copy();

                String name = rs.getString("name");
                int num = rs.getInt("num");
                Date date = rs.getDate("date");

                phone.setName(name);
                phone.setNum(num);
                phone.setDate(date);

                return phone;
            }
        });
        for (Phone_copy phone_copy : list) {
            System.out.println(phone_copy);
        }

    }

    @Test
    public void test3_2(){
        String sql = "select * from phone_copy";

        List<Phone_copy> list = template.query(sql, new BeanPropertyRowMapper<Phone_copy>(Phone_copy.class));

        for (Phone_copy phone_copy : list) {
            System.out.println(phone_copy);
        };
    }

    //查询记录数
    @Test
    public void test4(){
        String sql = "select count(*) from phone_copy";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }

}
