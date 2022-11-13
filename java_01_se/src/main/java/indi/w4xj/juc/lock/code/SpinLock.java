package indi.w4xj.juc.lock.code;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.lock.code
 * @Classname SpinLock
 * @Description
 * @Date 2021/2/13 14:41
 * @Created by IntelliJ IDEA
 */
public class SpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    /**
     * 获得锁
     */
    public void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " try to get the lock");
        //自旋
        while (!atomicReference.compareAndSet(null, thread)){
            //获取锁失败
        }
        //已经获得锁
        System.out.println(thread.getName() + " got the lock");
    }

    /**
     * 解锁
     */
    public void unlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(thread.getName() + " release the lock");
    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        new Thread(() ->{
            spinLock.lock();
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            spinLock.unlock();
        },"ThreadA").start();


        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(() ->{
            spinLock.lock();
            spinLock.unlock();
        },"ThreadB").start();

        /*
        打印：
            ThreadA try to get the lock
            ThreadA got the lock
            ThreadB try to get the lock
            ThreadA release the lock
            ThreadB got the lock
            ThreadB release the lock
         */
    }
}
