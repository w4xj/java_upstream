package indi.w4xj.pattern.singleton;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.singleton
 * @Classname Singleton04
 * @Description
 * @Date 2022/11/12 14:07
 * @Created by IntelliJ IDEA
 */
public enum Singleton04 {
    //用枚举的方式不能通过反射构造，且安全
    SINGLETON_04;
    public static Singleton04 Singleton04(){
        return SINGLETON_04;
    }
}
