package indi.w4xj.pattern.prototype.after;



/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.prototype.after
 * @Classname Main
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 15:13
 * @Created by IntelliJ IDEA
 */
public class Main {
    public static void main(String[] args) {
        //Sheep实现Cloneable接口，通过clone()即可完成，但是注意两个对象并不相等
        //spring中的bean可以配置为原型模式的，getBean("xxx")时会返回一个原型的对象实例
        Sheep sheep1 = new Sheep("沸羊羊",1);
        Sheep sheep2 = (Sheep)sheep1.clone();
        Sheep sheep3 = (Sheep)sheep1.clone();
        Sheep sheep4 = (Sheep)sheep1.clone();
        Sheep sheep5 = (Sheep)sheep1.clone();
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println("sheep1 == sheep2:" + (sheep1==sheep2));

    }
}
