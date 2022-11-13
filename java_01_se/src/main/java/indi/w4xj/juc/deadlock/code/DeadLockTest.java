package indi.w4xj.juc.deadlock.code;

import java.util.concurrent.TimeUnit;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.deadlock.code
 * @Classname DeadLockTest
 * @Description 
 * @Date 2021/2/15 12:46
 * @Created by IntelliJ IDEA
 */
public class DeadLockTest {
    public static void main(String[] args) {
        new Thread(new DeadLock("lockA", "lockB"),"ThreadA").start();
        new Thread(new DeadLock("lockB", "lockA"),"ThreadB").start();
    }
}

class DeadLock implements Runnable{
    private String lock1;
    private String lock2;
    public DeadLock(String lock1, String lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1){
            System.out.println(Thread.currentThread().getName() + "拿到" + lock1 + "，尝试拿" + lock2);
            //线程睡100毫秒
            try { TimeUnit.MILLISECONDS.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
            synchronized (lock2){
                System.out.println(Thread.currentThread().getName() + "拿到" + lock2);


            }
        }
    }
}
