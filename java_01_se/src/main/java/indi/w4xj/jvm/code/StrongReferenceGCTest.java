package indi.w4xj.jvm.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname StrongReferenceGCTest
 * @Description 
 * @Date 2021/2/16 11:17
 * @Created by IntelliJ IDEA
 */
public class StrongReferenceGCTest {
    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = obj1;

        obj1 = null;
        System.gc();
        System.out.println(obj1);
        System.out.println(obj2);
        /*
        打印：
            null
            java.lang.Object@1540e19d
         */
    }
}
