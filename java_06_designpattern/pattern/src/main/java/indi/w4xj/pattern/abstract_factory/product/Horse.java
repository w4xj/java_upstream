package indi.w4xj.pattern.abstract_factory.product;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.abstract_factory.before
 * @Classname Horse
 * @Description 
 * @Date 2022/11/12 18:48
 * @Created by IntelliJ IDEA
 */
public class Horse implements Rideable {
    @Override
    public void run() {
        System.out.println("骑马");
    }
}
