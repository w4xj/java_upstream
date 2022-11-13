package indi.w4xj.pattern.singleton;

import sun.security.jca.GetInstance;

import java.io.PipedReader;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.singleton
 * @Classname Singleton03
 * @Description 
 * @Date 2022/11/12 14:00
 * @Created by IntelliJ IDEA
 */
public class Singleton03 {
    private Singleton03 (){}
    //jvm加载静态内部类只加载一次，且是调用到此内部类时才初始化，实现懒加载
    private static class SingletonHolder{
        private final static Singleton03 singleton03 = new Singleton03();
    }
    public static Singleton03 getInstance(){
        return SingletonHolder.singleton03;
    }

}
