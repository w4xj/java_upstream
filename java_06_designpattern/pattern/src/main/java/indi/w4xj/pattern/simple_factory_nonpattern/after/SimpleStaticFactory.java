package indi.w4xj.pattern.simple_factory_nonpattern.after;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.simple_factory_nonpattern.after
 * @Classname SimpleStaticFactory
 * @Description 
 * @Date 2022/11/13 11:48
 * @Created by IntelliJ IDEA
 */
public class SimpleStaticFactory {
    //这个是简单静态工厂
    public static Car createCar() {
        return new Car();
    }

    public static Horse createHorse() {
        return new Horse();
    }

    public static Bicycle createBicycle() {
        return new Bicycle();
    }
}
