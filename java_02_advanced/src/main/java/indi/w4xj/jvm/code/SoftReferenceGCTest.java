package indi.w4xj.jvm.code;

import java.lang.ref.SoftReference;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname SoftReferenceGCTest
 * @Description TODO
 * @Date 2021/2/16 11:21
 * @Created by IntelliJ IDEA
 */
public class SoftReferenceGCTest {
    public static void main(String[] args) {
        enough();
        System.out.println("============================");
        notEnough();
    }

    private static void enough() {
        Object obj = new Object();
        System.out.println(obj);
        SoftReference<Object> softReference = new SoftReference<>(obj);
        obj = null;
        System.gc();
        System.out.println(obj);
        System.out.println(softReference.get());
        /*
        打印：
            java.lang.Object@1540e19d
            null
            java.lang.Object@1540e19d
         */

    }

    private static void notEnough() {
        Object obj = new Object();
        System.out.println(obj);
        SoftReference<Object> softReference = new SoftReference<>(obj);
        obj = null;
        try {
            //new 一个20M对象，触发GC
            String[] strings = new String[20 * 1024 * 1024];
        }catch (Throwable e){
            e.printStackTrace();
        }finally {
            System.out.println(obj);
            System.out.println(softReference.get());
        }
        /*
        打印：
            java.lang.Object@677327b6
            java.lang.OutOfMemoryError: Java heap space
                at indi.w4xj.jvm.code.SoftReferenceGC.notEnough(SoftReferenceGC.java:37)
                at indi.w4xj.jvm.code.SoftReferenceGC.main(SoftReferenceGC.java:16)
            null
            null
         */
    }
}
