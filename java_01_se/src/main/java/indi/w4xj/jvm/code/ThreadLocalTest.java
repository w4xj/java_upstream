package indi.w4xj.jvm.code;

import java.util.concurrent.TimeUnit;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname ThreadLocalTest
 * @Description TODO
 * @Date 2021/4/4 16:13
 * @Created by IntelliJ IDEA
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> tl = new ThreadLocal<>();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+ " read: " + tl.get());
           tl.set("A");
            System.out.println(Thread.currentThread().getName()+ " read: " + tl.get());
            try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName()+ " read: " + tl.get());
        },"A").start();

        new Thread(()->{
            try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName()+ " read: " + tl.get());
            tl.set("B");
            System.out.println(Thread.currentThread().getName()+ " read: " + tl.get());
        },"B").start();



    }
}
