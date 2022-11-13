package indi.w4xj.pattern.prototype.shallow_and_deep;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.prototype.shallow_and_deep
 * @Classname DeepClone
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 16:04
 * @Created by IntelliJ IDEA
 */
public class DeepClone {
    public static void main(String[] args) throws CloneNotSupportedException {

        //方式一：将引用类型变量单独克隆一次
        Cat cat1  = new Cat("汤姆", new Owner("两只鞋太太"));
//        Cat cat2 = (Cat) cat1.clone();

        //方式二：将对象序列化再反序列化（推荐）
        Cat cat2 = (Cat)cat1.deepClone();
        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println("cat1 == cat2: " + (cat1 == cat2));
        System.out.println("cat1.owner == cat2.owner: " + (cat1.getOwner() == cat2.getOwner()));



    }
}
