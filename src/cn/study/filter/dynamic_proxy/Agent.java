package cn.study.filter.dynamic_proxy;

/**
 * @author Komorebi
 * @date 2022.05.23.20:07
 */
public class Agent implements SaleComputer{
    @Override
    public String sale(double money) {
        System.out.println("代理商花了"+money+"元买了一台电脑");
        return "新电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑。。。");
    }
}
