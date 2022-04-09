package cn.study.annotation;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Komorebi
 * @since 2022.04.08.16:41
 *
 * 框架
 *
 */

@Pro(className = "cn.study.annotation.Demo1",methodName = "show")
public class FrameClass {
    public static void main(String[] args) throws Exception {
        /**
         * 在程序中解析注解
         */
        //1.解析注解
        //1.1获取该类的字节码文件对象
        Class<FrameClass> frameClassClass = FrameClass.class;
        //2.获取上边的注解对象
        //其实就是在内存中生成了一个该注解接口的子类实现对象
        Pro an = frameClassClass.getAnnotation(Pro.class);

        /*public class ProImpl implements Pro{
            public String className(){
                return "cn.study.annotation.Demo1";
            }
            public String methodName(){
                return "show";
            }
        }*/

        //3.调用注解对象中定义的抽象方法，获取返回值
        String className = an.className();
        String methodName = an.methodName();
        System.out.println(className);
        System.out.println(methodName);

        Class cls = Class.forName(className);
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);
        method.invoke(obj);
    }

}
