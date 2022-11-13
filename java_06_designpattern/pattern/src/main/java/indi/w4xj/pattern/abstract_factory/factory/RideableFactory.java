package indi.w4xj.pattern.abstract_factory.factory;

import indi.w4xj.pattern.abstract_factory.product.Rideable;
import indi.w4xj.pattern.abstract_factory.product.Wearable;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.abstract_factory.factory
 * @Classname RideableFactory
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 12:33
 * @Created by IntelliJ IDEA
 */
public interface RideableFactory {
    //购买
    Rideable buy();
    //附赠
    Wearable free();
}
