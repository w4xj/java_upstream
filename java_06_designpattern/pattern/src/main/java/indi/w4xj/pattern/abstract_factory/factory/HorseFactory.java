package indi.w4xj.pattern.abstract_factory.factory;

import indi.w4xj.pattern.abstract_factory.product.Horse;
import indi.w4xj.pattern.abstract_factory.product.Jackboots;
import indi.w4xj.pattern.abstract_factory.product.Rideable;
import indi.w4xj.pattern.abstract_factory.product.Wearable;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.abstract_factory.factory
 * @Classname HorseFactory
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 12:59
 * @Created by IntelliJ IDEA
 */
public class HorseFactory implements RideableFactory {
    @Override
    public Rideable buy() {
        return new Horse();
    }

    @Override
    public Wearable free() {
        return new Jackboots();
    }
}
