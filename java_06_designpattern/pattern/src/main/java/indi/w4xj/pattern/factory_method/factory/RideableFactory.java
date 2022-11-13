package indi.w4xj.pattern.factory_method.factory;

import indi.w4xj.pattern.factory_method.product.Rideable;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.factory_method.factory
 * @Classname RideableFactory
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 12:33
 * @Created by IntelliJ IDEA
 */
public interface RideableFactory {
    Rideable create();
}
