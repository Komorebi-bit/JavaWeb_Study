package cn.study.filter.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * @author Komorebi
 * @date 2022.05.23.20:11
 */
public class Test {
    public static void main(String[] args){
        //创建真实对象
        Agent agent = new Agent();
        //动态代理增强agent对象
        /**
         * 参数1:类加载器
         * 2:接口数组
         * 3:处理器
         */
        SaleComputer proxy_agent = (SaleComputer) Proxy.newProxyInstance(agent.getClass().getClassLoader(), agent.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 代理逻辑编写的方法：代理对象调用的所有方法都会触发该方法执行。
             * 增强方式：
             * 1.增强参数列表
             * 2.增强返回值类型
             * 3.增强方法体执行逻辑
             * @param proxy 代理对象，指proxy_agent
             * @param method 代理对象调用的方法被封装为的对象
             * @param args 代理对象调用方法时，传递的实际参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                // System.out.println(method.getName());
                // System.out.println(args[0]);
                //使用真实对象调用方法
                // Object obj = method.invoke(agent, args);
                Object obj = null;
                //1.增强参数（首先得有参数）
                if(method.getName().equals("sale")){
                    double money = (double)args[0];
                    System.out.println("客户花了"+money+"买了台新电脑");
                    money = money * 0.85;
                    //增强方法体执行逻辑
                    System.out.println("专车接你。。。");
                    String o = (String) method.invoke(agent,money);
                    System.out.println("送货到门。。。");
                    //增强返回值
                    return o+"_鼠标";
                }else{
                    obj = method.invoke(agent,args);
                }
                return obj;
            }
        });
        //调用方法
        String computer = proxy_agent.sale(8000);
        System.out.println(computer);
    }
}
