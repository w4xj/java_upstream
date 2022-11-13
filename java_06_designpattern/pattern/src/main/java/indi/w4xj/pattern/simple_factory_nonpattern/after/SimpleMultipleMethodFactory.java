package indi.w4xj.pattern.simple_factory_nonpattern.after;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.simple_factory_nonpattern.after
 * @Classname SimpleMultipleMethodFactory
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 12:02
 * @Created by IntelliJ IDEA
 */
public class SimpleMultipleMethodFactory {
    //这个是简单静态工厂
    public  Car createCar() {
        return new Car();
    }

    public  Horse createHorse() {
        return new Horse();
    }

    public  Bicycle createBicycle() {
        return new Bicycle();
    }
}
