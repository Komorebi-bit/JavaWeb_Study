package cn.study.test;

import cn.study.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Komorebi
 * @since 2022.04.08.9:53
 *
 * JUnit 单元测试
 *
 * @Test 注解可时方法独立运行
 * Assert 断言，比较两个值是否相等
 * @
 */
public class CalculatorTest {
    /**
     * 初始化方法
     * 用于资源申请，所有测试方法在执行之前都会先执行此方法
     */
    @Before
    public void init(){
        System.out.println("init...");

    }

    /**
     * 释放资源方法
     * 所有测试方法执行完后，自动执行此方法
     */
    @After
    public void close(){
        System.out.println("close...");
    }

    /**
     * 测试方法
     * 可独立运行
     */
    @Test
    public void testAdd(){

        System.out.println("testAdd...");
        Calculator c = new Calculator();
        int result = c.add(1,2);
        //预测结果是3
        Assert.assertEquals(3,result);

        // System.out.println(c.add(1,2));
    }

    @Test
    public void testSub(){
        Calculator c = new Calculator();
        int result = c.sub(6,2);

        //错误示范
        //Assert.assertEquals(3,result);
    }
}
