package com.w4xj.principle.single.responsibility;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package com.w4xj.principle.single.responsibility
 * @Classname SingleResponsibility3
 * @Description TODO
 * @Date 2021/3/13 12:35
 * @Created by IntelliJ IDEA
 */
public class SingleResponsibility3 {

    public static void main(String[] args) {
        Vehicle3 vehicle3 = new Vehicle3();
        vehicle3.run("汽车");
        vehicle3.runAir("飞机");
        vehicle3.runWater("轮船");

        /**
         * 运行结果：
         * 汽车 在公路上运行....
         * 飞机 在天空上运行....
         * 轮船 在水中行....
         */
    }
}
class Vehicle3 {
    public void run(String vehicle) {
        //处理

        System.out.println(vehicle + " 在公路上运行....");

    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + " 在天空上运行....");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + " 在水中行....");
    }

}