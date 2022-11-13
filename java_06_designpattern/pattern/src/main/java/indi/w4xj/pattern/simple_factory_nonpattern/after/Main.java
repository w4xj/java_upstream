package indi.w4xj.pattern.simple_factory_nonpattern.after;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.simple_factory_nonpattern.after
 * @Classname Main
 * @Description 
 * @Date 2022/11/13 11:49
 * @Created by IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        //创建实例的过程交给工厂来做，但是这种方式的可扩展性并不好，新添加一个交通工具还得添加一个方法，引出工厂方法

        //简单普通工厂
        SimpleNormalFactory simpleNormalFactory = new SimpleNormalFactory();
        Rideable rideable = simpleNormalFactory.create("car");
//        Rideable rideable = simpleNormalFactory.create("horse");
//        Rideable rideable = simpleNormalFactory.create("bicycle");

        //简单多方法工厂
//        SimpleMultipleMethodFactory simpleMultipleMethodFactory = new SimpleMultipleMethodFactory();
//        Rideable rideable = simpleMultipleMethodFactory.createCar();
//        Rideable rideable = simpleMultipleMethodFactory.createBicycle();
//        Rideable rideable = simpleMultipleMethodFactory.createHorse();

        //简单静态工厂
//        Rideable rideable = SimpleStaticFactory.createCar();
//        Rideable rideable = SimpleFactory.createBicycle();
//        Rideable rideable = SimpleFactory.createHorse();



        rideable.run();
    }

}
