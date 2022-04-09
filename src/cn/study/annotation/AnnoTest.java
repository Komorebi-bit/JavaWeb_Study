package cn.study.annotation;

/**
 * @author Komorebi
 * @date 2022.04.08.19:57
 */

@MyAnno(age=10,ee=E.E1,anno2=@MyAnno2,str={"aaa","bbb","ccc"})
@MyAnno3
public class AnnoTest {

    //@MyAnno3
    public void f(){

    }
}
