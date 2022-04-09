package cn.study.annotation.demo;

/**
 * @author Komorebi
 * @date  2022.04.09
 */
public class Calculator {
    @Check
    public void add(){
        String s=null;
        s.toString();
        System.out.println("1+0="+(1+0));
    }

    @Check
    public void sub() {
        System.out.println("1-0="+(1-0));
    }

    @Check
    public void mul(){
        System.out.println("1*0="+1*0);
    }

    @Check
    public void div(){
        System.out.println("1/0="+1/0);
    }
}
