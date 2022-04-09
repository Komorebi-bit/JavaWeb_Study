package cn.study.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})//表示该注解只能作用在类上
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnno3 {
}
