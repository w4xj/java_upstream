package indi.w4xj.pattern.abstract_factory.factory;

import indi.w4xj.pattern.abstract_factory.product.Bicycle;
import indi.w4xj.pattern.abstract_factory.product.Helmet;
import indi.w4xj.pattern.abstract_factory.product.Rideable;
import indi.w4xj.pattern.abstract_factory.product.Wearable;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.abstract_factory.factory
 * @Classname BicycleFactory
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 12:59
 * @Created by IntelliJ IDEA
 */
public class BicycleFactory implements RideableFactory {

    @Override
    public Rideable buy() {
        return new Bicycle();
    }

    @Override
    public Wearable free() {
        return new Helmet();
    }
}
