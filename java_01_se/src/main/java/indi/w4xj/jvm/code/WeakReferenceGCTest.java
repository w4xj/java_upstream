package indi.w4xj.jvm.code;

import java.lang.ref.WeakReference;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname WeakReferenceGCTest
 * @Description TODO
 * @Date 2021/2/16 11:32
 * @Created by IntelliJ IDEA
 */
public class WeakReferenceGCTest {
    public static void main(String[] args) {
        Object o = new Object();
        WeakReference<Object> weakReference = new WeakReference<Object>(o);
        System.out.println(o);
        System.out.println(weakReference.get());
        System.out.println("========================");
        o = null;
        System.gc();
        System.out.println(weakReference.get());
    }
}
