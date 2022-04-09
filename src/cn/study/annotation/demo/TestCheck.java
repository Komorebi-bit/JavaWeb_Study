package cn.study.annotation.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Komorebi
 * @date 2022.04.09.11:37
 *
 * 简单的测试框架
 * 当主方法被执行后，会自动执行被注解的所有方法(Check注解),判断方法是否有异常，有记录在文件中
 */
public class TestCheck {
    public static void main(String[] args) throws IOException {
        Calculator c = new Calculator();
        //获取字节码文件对象
        Class cls = c.getClass();
        //获取所有方法
        Method[] methods = cls.getMethods();

        //出现的异常的次数
        int count=0;
        //
        BufferedWriter bw = new BufferedWriter(new FileWriter("bug.txt"));

        for (Method method: methods) {
            //判断方法上是否有Check注解
            if(method.isAnnotationPresent(Check.class)){
                //有就执行
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    //记录异常到文件中
                    count++;
                    bw.write(method.getName()+" 方法出异常了");
                    bw.newLine();
                    //e.getCause() 获取异常的真实原因
                    bw.write("异常名称: "+e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因: "+e.getCause().getMessage());
                    bw.newLine();
                    bw.write("---------------------");
                    bw.newLine();
                }
            }
        }
        bw.write("本次一共出现"+count+"次异常");
        bw.flush();
        bw.close();
    }
}
