package indi.w4xj.pattern.simple_factory_nonpattern.before;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.factory_method.before
 * @Classname Main
 * @Description 
 * @Date 2022/11/12 18:48
 * @Created by IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        //根据单一原则的理论，将各个交通工具封装到各自的实现
        Rideable rideable = new Bicycle();
//        Rideable rideable = new Car();
//        Rideable rideable = new Horse();
        rideable.run();
    }
}
