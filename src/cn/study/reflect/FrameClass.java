package cn.study.reflect;

import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Properties;

/**
 * @author Komorebi
 * @since 2022.04.08.16:41
 *
 *需求  写一个框架，帮我们创建任意类对象，并且执行其中任意方法
 *      实现
 *          1.配置文件
 *          2.反射
 *      步骤
 *          1.将需要创建的对象的全类名和需要执行的方法定义在配置文件中
 *          2.在程序中加载读取配置文件
 *          3.使用反射技术来加载类文件进内存
 *          4.创建对象
 *          5.执行方法
 *
 *  可以使用静态代码块，对文件读取
 */
public class FrameClass {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        //1.1创建Properties对象
        Properties pro = new Properties();
        //1.2加载加载配置文件，转化为一个集合,Properties为map的子类
        //1.2.1获取class目录下的配置文件
        ClassLoader classLoader = FrameClass.class.getClassLoader();//获取字节码文件的类加载器

        // 两种方式...
        // InputStream is = classLoader.getResourceAsStream("frame.properties");//获取资源对应的字节流
        // pro.load(is);
        URL url = classLoader.getResource("frame.properties");
        String path = url.getPath();
        pro.load(new FileReader(path));

        //2.获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        //3.加载该类进内存
        Class cls = Class.forName(className);
        //4.创建对象
        Object obj = cls.newInstance();
        //5.获取方法对象
        Method method = cls.getMethod(methodName);
        //6.执行方法
        method.invoke(obj);
    }

}
