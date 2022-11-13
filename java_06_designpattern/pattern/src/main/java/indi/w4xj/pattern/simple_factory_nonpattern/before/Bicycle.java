package indi.w4xj.pattern.simple_factory_nonpattern.before;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.factory_method.before
 * @Classname Bicycle
 * @Description 
 * @Date 2022/11/12 18:47
 * @Created by IntelliJ IDEA
 */
public class Bicycle implements Rideable{
    @Override
    public void run() {
        System.out.println("骑自行车");
    }
}
