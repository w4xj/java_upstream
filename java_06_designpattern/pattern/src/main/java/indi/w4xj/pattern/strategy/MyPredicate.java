package indi.w4xj.pattern.strategy;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.strategy
 * @Classname MyPredicat
 * @Description 
 * @Date 2022/11/12 16:31
 * @Created by IntelliJ IDEA
 */
public interface MyPredicate<T> {
    boolean test(T t);
}
