package cn.study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 描述需要执行的类名，和方法名
 */

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Pro {
    String className();
    String methodName();
}

/*
* @Pro(className = "cn.study.annotation.Demo1",methodName = "show")
*
* frameClassClass.getAnnotation(Pro.class);
* 此代码在内存中生成如下...
*
* public class ProImpl implements Pro{
*       public String className(){
*           return "cn.study.annotation.Demo1"
*       }
*       public String methodName(){
*           return "show"
*       }
* }
*
*/
