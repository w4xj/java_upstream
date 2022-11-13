package indi.w4xj.pattern.abstract_factory;

import indi.w4xj.pattern.abstract_factory.factory.BicycleFactory;
import indi.w4xj.pattern.abstract_factory.factory.CarFactory;
import indi.w4xj.pattern.abstract_factory.factory.HorseFactory;
import indi.w4xj.pattern.abstract_factory.factory.RideableFactory;
import indi.w4xj.pattern.abstract_factory.product.Rideable;
import indi.w4xj.pattern.abstract_factory.product.Wearable;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.abstract_factory
 * @Classname Main
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 13:47
 * @Created by IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        //对于不同的产品族，拥有不同的工厂，扩展新的产品组，增加新的工厂即可，如加一个滑板滑板工厂，买滑板送护膝
        //工厂方法：没有族的概念，工厂只能生产一种产品
        //抽象工厂：一个新的工厂可以生产一个产品族，但是要在工厂里面新加产品，还得修改抽象的工厂，那么其他的工厂也需要修改，引出Spring的工厂
        RideableFactory rideableFactory = new CarFactory();
//        RideableFactory rideableFactory = new HorseFactory();
//        RideableFactory rideableFactory = new BicycleFactory();
        Rideable rideable = rideableFactory.buy();
        Wearable wearable = rideableFactory.free();
        wearable.wear();
        rideable.run();
    }
}
