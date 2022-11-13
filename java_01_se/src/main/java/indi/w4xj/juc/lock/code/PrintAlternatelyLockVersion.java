package indi.w4xj.juc.lock.code;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.blockingqueue.code
 * @Classname ProducerConsumerLockVersion
 * @Description 
 * @Date 2021/2/14 14:47
 * @Created by IntelliJ IDEA
 */
public class PrintAlternatelyLockVersion {
    public static void main(String[] args) {
        /*
        线程操作资源类
        判断、干活、再唤醒
        防止虚假唤醒
         */
        LockResource resource = new LockResource();
        new Thread(() ->{
            try {
                for (int i = 0; i < 5; i++) {
                    resource.increment();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"ThreadA").start();


        new Thread(() ->{
            try {
                for (int i = 0; i < 5; i++) {
                    resource.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"ThreadB").start();


        /*
        打印：
            ThreadA    1
            ThreadB    0
            ThreadA    1
            ThreadB    0
            ThreadA    1
            ThreadB    0
            ThreadA    1
            ThreadB    0
            ThreadA    1
            ThreadB    0
         */
    }
}


class LockResource{
    private int number = 0;
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void increment() throws InterruptedException {
        lock.lock();
        try {
            //while防止虚假唤醒
            while (number != 0) {
                condition.await();
            }
            number++ ;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement() throws InterruptedException {
        lock.lock();
        try {
            //while防止虚假唤醒
            while (number == 0) {
                condition.await();
            }
            number-- ;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
