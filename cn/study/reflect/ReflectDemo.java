package cn.study.reflect;

import cn.study.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.Period;

/**
 * @author Komorebi
 * @since 2022.04.08.15:12
 *
 * 反射机制
 * 获取Class对象的方法
 *      1.Class.forName("全类名") 将字节码文件加载到内存，返回Class对象
 *          多用于配置文件，将类名定义在配置文件中。读取文件加载类
 *      2.类名.class 通过类名的属性class获取
 *          多用于参数的传递
 *      3.对象.getClass() 此方法在Object类中定义
 *          多用于对象获取字节码方式
 * Class对象功能
 *      1.获取属性
 *          获取所有Public的
 *          Field[] getFields()
 *          Field getField(String name)
 *          获取所有的成员变量
 *          Field[] getDeclaredFields()
 *          Field getDeclaredField(String name)
 *      2.获取方法
 *          Constructor<?>[] getConstructors()
 *          Constructor<T> getConstructor(类<?>... parameterTypes)
 *
 *          Constructor<?>[] getDeclaredConstructors()
 *          Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
 *
 *          method[] getMethods()
 *          method getMethod(String name, 类<?>... parameterTypes)
 *
 *          method[] getDeclaredMethods()
 *          method getDeclaredMethod(String name, 类<?>... parameterTypes)
 *      3.获取类名
 *          String getName()
 *      .setAccessible(true);//暴力反射
 */
public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        //1
        Class cls1 = Class.forName("cn.study.domain.Person");
        System.out.println(cls1);
        //2
        Class cls2 = Person.class;
        System.out.println(cls2);
        //3
        Person p = new Person();
        Class cls3 = p.getClass();
        System.out.println(cls3);

        System.out.println(cls1==cls2);
        System.out.println(cls2==cls3);
        //同一个字节码文件(*.class)在一次程序运行过程中，只会被加载一次，不论通过哪种方式获取的class对象都是同一个

        System.out.println("-----------  1  ------------");

        Class pclass = Person.class;
        Field[] fields = pclass.getFields();
        for (Field field: fields) {
            System.out.println(field);
        }

        Field name = pclass.getField("name");
        Object value = name.get(p);
        System.out.println(value);

        name.set(p,"123");
        value = name.get(p);
        System.out.println(value);

        Field[] allfields = pclass.getDeclaredFields();
        for (Field field: allfields) {
            System.out.println(field);
        }

        //age 私有属性
        Field age = pclass.getDeclaredField("age");
        //忽略访问权限修饰符的安全检查
        age.setAccessible(true);//暴力反射
        Object value2 = age.get(p);
        System.out.println(value2);

        System.out.println("-----------  2  ------------");

        Constructor constructor = pclass.getConstructor(String.class,int.class);
        System.out.println(constructor);
        //创造对象
        Object person = constructor.newInstance("曹操",50);
        System.out.println(person);

        //无参的可以简化为
        Object o = pclass.newInstance();
        System.out.println(o);

        System.out.println("-----------  3  ------------");
        Method eat1 = pclass.getMethod("eat");//参数为 方法名，方法参数
        eat1.invoke(p);//参数 对象

        Method eat2 = pclass.getMethod("eat",String.class);
        eat2.invoke(p,"水果");

        Method[] methods = pclass.getMethods();
        for (Method method: methods) {
            System.out.println(method);
            //获取方法名
            System.out.println(method.getName());
        }

        System.out.println("-----------  4  ------------");
        String classname = pclass.getName();
        System.out.println(classname);//全类名
    }
}
