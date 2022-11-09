package com.w4xj.principle.single_responsibility;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package com.w4xj.principle.single.responsibility
 * @Classname SingleResponsibility2
 * @Description TODO
 * @Date 2021/3/13 12:35
 * @Created by IntelliJ IDEA
 */
public class SingleResponsibility2 {
    public static void main(String[] args) {
        /**
         * 方案2的分析
         * 1.遵守单一职责原则
         * 2.但是这样做的改动很大，即将类分解，同时修改客户端
         * 3.改进：直接修改Vehicle类，改动会比较少
         */

        RoadVehicle roadVehicle = new RoadVehicle();
        roadVehicle.run("摩托车");

        WaterVehicle waterVehicle = new WaterVehicle();
        waterVehicle.run("轮船");

        AirVehicle airVehicle = new AirVehicle();
        airVehicle.run("飞机");

        /**
         * 运行结果：
         * 摩托车公路运行
         * 轮船水中运行
         * 飞机天空运行
         */
    }
}

class RoadVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "公路运行");
    }
}

class AirVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "天空运行");
    }
}

class WaterVehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "水中运行");
    }
}