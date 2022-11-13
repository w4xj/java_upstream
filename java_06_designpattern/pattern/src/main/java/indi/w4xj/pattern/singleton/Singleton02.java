package indi.w4xj.pattern.singleton;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.singleton
 * @Classname Singleton02
 * @Description 
 * @Date 2022/11/12 13:52
 * @Created by IntelliJ IDEA
 */
public class Singleton02 {
    //DCL 在没有反射破坏的情况也是单例的
    private Singleton02(){}
    private static volatile Singleton02 singleton02;
    public static Singleton02 getInstance(){
        if(singleton02 == null){
            synchronized (Singleton02.class){
                if(singleton02 == null){
                    singleton02 = new Singleton02();
                }
            }
        }
        return singleton02;
    }
}
