package indi.w4xj.pattern.abstract_factory.product;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.abstract_factory.product
 * @Classname Helmet
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 13:36
 * @Created by IntelliJ IDEA
 */
public class Helmet implements Wearable{
    @Override
    public void wear() {
        System.out.println("戴头盔");
    }
}
