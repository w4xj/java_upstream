package indi.w4xj.jvm.code;

import java.util.concurrent.TimeUnit;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname FinalizeTest01
 * @Description 
 * @Date 2021/4/1 23:18
 * @Created by IntelliJ IDEA
 */
public class FinalizeTest01 {
    public static void main(String[] args) {
        T t = new T();
        t = null;
        System.gc();
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
    }
    private static class T{
        //垃圾回收时调用
        @Override
        protected void finalize() throws Throwable {
            System.out.println("invoke finalize");
        }
    }
}
