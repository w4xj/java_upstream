package indi.w4xj.pattern.simple_factory_nonpattern.after;

import javafx.beans.binding.When;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.simple_factory_nonpattern.after
 * @Classname SimpleNormalFactory
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 12:03
 * @Created by IntelliJ IDEA
 */
public class SimpleNormalFactory {

    public Rideable create(String type) {
        switch (type) {
            case "car":
                return new Car();
            case "horse":
                return new Horse();
            case "bicycle":
                return new Bicycle();
            default: throw new RuntimeException("no such Rideable type");
        }
    }

}
