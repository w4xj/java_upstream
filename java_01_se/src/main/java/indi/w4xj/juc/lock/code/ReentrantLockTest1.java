package indi.w4xj.juc.lock.code;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.lock.code
 * @Classname ReentrantLockTest1
 * @Description 
 * @Date 2021/2/13 14:27
 * @Created by IntelliJ IDEA
 */
public class ReentrantLockTest1 {
    public static void main(String[] args) {
        CXK cxk = new CXK();
        new Thread(cxk, "Thread1").start();
        new Thread(cxk, "Thread2").start();

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("-----------------------------------------");

        new Thread(() ->{ cxk.sing(); },"Thread3").start();
        new Thread(() ->{ cxk.sing(); },"Thread3").start();
        /*
        打印：
            Thread1 music~
            Thread1 basketball~
            Thread2 music~
            Thread2 basketball~
            -----------------------------------------
            Thread3 sing~
            Thread3 dance~
            Thread3 rap~
            Thread3 sing~
            Thread3 dance~
            Thread3 rap~
         */
    }
}

class CXK implements Runnable{
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        music();
    }

    public void music(){
        //注意这里双锁依然是可以，但是锁一定要配对，不然会真正的死锁
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " music~");
            basketball();
        }finally {
            lock.unlock();
            lock.unlock();
        }
    }
    public void basketball(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " basketball~");
        }finally {
            lock.unlock();
        }
    }

    public synchronized void sing(){
        System.out.println(Thread.currentThread().getName() + " sing~");
        dance();
    }

    public synchronized void dance(){
        System.out.println(Thread.currentThread().getName() + " dance~");
        rap();
    }
    public synchronized void rap(){
        System.out.println(Thread.currentThread().getName() + " rap~");
    }
}
