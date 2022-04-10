package cn.study.domain;

import java.util.Date;

/**
 * @author Komorebi
 * @date 2022.04.10.11:34
 */
public class Phone_copy {
    private String name;
    private int num;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Phone_copy{" +
                "name='" + name + '\'' +
                ", num=" + num +
                ", date=" + date +
                '}';
    }
}
