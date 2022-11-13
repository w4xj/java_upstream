package indi.w4xj.pattern.factory_method.factory;

import indi.w4xj.pattern.factory_method.product.Horse;
import indi.w4xj.pattern.factory_method.product.Rideable;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.factory_method.factory
 * @Classname HorseFactory
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 12:59
 * @Created by IntelliJ IDEA
 */
public class HorseFactory implements RideableFactory{
    @Override
    public Rideable create() {
        return new Horse();
    }
}
