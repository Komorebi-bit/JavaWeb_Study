package cn.study.annotation;

/**
 * @author Komorebi
 * @date 2022.04.08.19:28
 *
 * 自定义注解
 * 格式：
 *      元注解
 *      public @interface 注解名称{
 *          属性列表
 *      }
 * 注解本质：
 *      public interface MyAnno extends java.lang.annotation.Annotation
 *      就是一个接口，该接口默认继承了Annotation接口
 * 属性：
 *      接口中的方法
 *   要求：
 *      1.属性的返回值类型
 *          基本数据类型
 *          String
 *          枚举
 *          注解
 *          以上类型的数组
 *          无void
 *      2.定义了属性，在使用时需要给属性赋值
 *          1.default 关键字给属性默认值，使用注解时可以不用赋值
 *          2.如果只有一个属性需要赋值，并且属性的名称是value，value可以省略，直接定义值
 *          3.数组赋值时，值用{}包裹，数组中只有一个值，{}可以省略
 *  元注解：
 *      用于描述注解的注解
 *      *@Target: 描述注解能够作用的位置
 *          ElementType取值
 *              TYPE: 作用与类上
 *              METHOD: 作用与方法上
 *              FIELD: 作用与成员变量上
 *      *@Retention: 描述注解被保留的阶段
 *          *@Retention(RetentionPolicy.RUNTIME) 当前被描述的注解，会保留到class字节码文件中，并被JVM读取到
 *          CLASS 不会被JVM读取到，SOURCE 也不会保留到class字节码文件上
 *          自定义的注解，多用RUNTIME
 *      *Documented: 描述注解是否被抽取到api文档中
 *      *Inherited: 描述注解是否被子类继承
 *
 * javac 编译
 * javap 反编译
 * javadoc 生成文档
 */
public @interface MyAnno {
    int age();
    String name() default "译名";
    E ee();//枚举
    MyAnno2 anno2();//注解
    String[] str();
}
