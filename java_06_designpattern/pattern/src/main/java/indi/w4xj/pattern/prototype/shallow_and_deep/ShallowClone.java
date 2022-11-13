package indi.w4xj.pattern.prototype.shallow_and_deep;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.prototype.shallow_and_deep
 * @Classname ShallowClone
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 15:49
 * @Created by IntelliJ IDEA
 */
public class ShallowClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        //这里可以看出默认的拷贝是浅拷贝
        //对于基本数据类型是直接拷贝值，引用类型则是直接拷贝的引用值，还是同一个对象
        Dog dog1 = new Dog("旺财", new Owner("常威"));
        Dog dog2 = (Dog) dog1.clone();
        System.out.println("dog1 == dog2: " + (dog1 == dog2));
        System.out.println("dog1.owner == dog2.owner: " + (dog1.getOwner() == dog2.getOwner()));
        /**
         * dog1 == dog2: false
         * dog1.owner == dog2.owner: true
         */
    }
}


