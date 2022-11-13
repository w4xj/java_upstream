package com.w4xj.principle.single_responsibility;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package com.w4xj.principle.single.responsibility
 * @Classname SingleResponsibility3
 * @Description 
 * @Date 2021/3/13 12:35
 * @Created by IntelliJ IDEA
 */
public class SingleResponsibility3 {

    public static void main(String[] args) {
        /**
         * 方式3分析
         * 这种修改方式没有对原来的类做大的修改，只是增加方法
         * 这里虽然没有在类的级别上遵守单一职责，但在方法级别上遵守了单一职责
         */
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