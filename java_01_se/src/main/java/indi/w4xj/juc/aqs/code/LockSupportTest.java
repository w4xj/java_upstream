package indi.w4xj.juc.aqs.code;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.aqs.code
 * @Classname LockSupportTest
 * @Description 
 * @Date 2021/3/29 20:13
 * @Created by IntelliJ IDEA
 */
public class LockSupportTest {
    public static void main(String[] args) {

        //写法1和写法2都能使线程A顺利执行
        //注意执行unpark前，被unpark的类一定要先start
        //内部是用一个permit通行证实现0表示未拿到通行证，1表示拿到通行证

        //方式1：
        Thread a1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t start...");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + " \t over...");
        }, "A1");
        a1.start();

        Thread b1 = new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            LockSupport.unpark(a1);
            System.out.println(Thread.currentThread().getName() + "\t unpark A...");
        }, "B1");
        b1.start();


        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("---------------------------------------");


        //方式2：
        Thread a2 = new Thread(() -> {
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            System.out.println(Thread.currentThread().getName() + "\t start...");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + " \t over...");
        }, "A2");
        a2.start();

        Thread b2 = new Thread(() -> {
            LockSupport.unpark(a2);
            System.out.println(Thread.currentThread().getName() + "\t unpark A...");
        }, "B2");
        b2.start();

    }
}
