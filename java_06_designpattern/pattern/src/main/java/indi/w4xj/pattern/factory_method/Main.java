package indi.w4xj.pattern.factory_method;

import indi.w4xj.pattern.factory_method.factory.BicycleFactory;
import indi.w4xj.pattern.factory_method.factory.CarFactory;
import indi.w4xj.pattern.factory_method.factory.HorseFactory;
import indi.w4xj.pattern.factory_method.factory.RideableFactory;
import indi.w4xj.pattern.factory_method.product.Rideable;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.factory_method
 * @Classname Main
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 13:01
 * @Created by IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        //通过返回不同的工厂，来返回不同的工厂实例，通过工厂获取产品实例
        //工厂方法中，一个工厂只能生产一个产品，一个工厂生产一套产品，引出抽象工厂
        RideableFactory rideableFactory = new CarFactory();
//        RideableFactory rideableFactory = new HorseFactory();
//        RideableFactory rideableFactory = new BicycleFactory();
        Rideable rideable = rideableFactory.create();
    }
}
