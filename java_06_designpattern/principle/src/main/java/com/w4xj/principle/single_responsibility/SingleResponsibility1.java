package com.w4xj.principle.single_responsibility;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package com.w4xj.principle.single.responsibility
 * @Classname SingleResponsibility1
 * @Description TODO
 * @Date 2021/3/13 12:35
 * @Created by IntelliJ IDEA
 */
public class SingleResponsibility1 {
    public static void main(String[] args) {
        Vehicle1 v = new Vehicle1();
        v.run("汽车");
        v.run("轮船");
        v.run("飞机");
        /**
         * 运行结果：
         * 汽车在公路上跑
         * 轮船在公路上跑
         * 飞机在公路上跑
         */
    }
}

class Vehicle1 {
    public void run(String str) {
        System.out.println(str + "在公路上跑");
    }
}