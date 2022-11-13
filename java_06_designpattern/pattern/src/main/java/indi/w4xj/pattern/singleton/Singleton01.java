package indi.w4xj.pattern.singleton;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.singleton
 * @Classname Singleton01
 * @Description
 * @Date 2022/11/12 13:49
 * @Created by IntelliJ IDEA
 */
public class Singleton01 {
    //饿汉式  线程安全（但是反射能破坏其单例）
    private Singleton01(){}
    public static Singleton01 singleton01 = new Singleton01();
    public static Singleton01 getInstance(){
        return singleton01;
    }

}
