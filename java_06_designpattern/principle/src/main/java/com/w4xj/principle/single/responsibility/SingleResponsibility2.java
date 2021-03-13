package com.w4xj.principle.single.responsibility;

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