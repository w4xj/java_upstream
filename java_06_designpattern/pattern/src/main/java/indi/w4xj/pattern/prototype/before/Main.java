package indi.w4xj.pattern.prototype.before;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.prototype.before
 * @Classname Main
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 15:01
 * @Created by IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {

        Sheep sheep1 = new Sheep("沸羊羊",1);
        Sheep sheep2 = new Sheep(sheep1.getName(),sheep1.getAge());
        Sheep sheep3 = new Sheep(sheep1.getName(),sheep1.getAge());
        Sheep sheep4 = new Sheep(sheep1.getName(),sheep1.getAge());
        Sheep sheep5 = new Sheep(sheep1.getName(),sheep1.getAge());
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
        System.out.println(sheep5);

    }
}
