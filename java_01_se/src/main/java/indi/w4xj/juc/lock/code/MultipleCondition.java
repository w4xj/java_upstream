package indi.w4xj.juc.lock.code;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.lock.code
 * @Classname MultipleCondition
 * @Description TODO
 * @Date 2021/2/13 15:19
 * @Created by IntelliJ IDEA
 */
public class MultipleCondition {
    public static void main(String[] args) {
        ShareResouce shareResouce = new ShareResouce();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                shareResouce.printA();
            }
        },"ThreadA").start();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                shareResouce.printB();
            }
        },"ThreadB").start();
        new Thread(() ->{
            for (int i = 0; i < 10; i++) {
                shareResouce.printC();
            }
        },"ThreadC").start();
        /*
        打印：
            ThreadA A
            ThreadB B
            ThreadC C
            ...
            ThreadA A
            ThreadB B
            ThreadC C
         */
    }


}


//资源类
class ShareResouce{
    /**
     * 标志位
     */
    private int current = 1;
    /**
     * 锁
     */
    private Lock lock = new ReentrantLock();
    /**
     * 多条件
     */
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    public void printA(){
        lock.lock();
        try {
            while (current != 1){
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName() + " A");
            //修改标志位
            current = 2;
            //唤醒
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void printB(){
        lock.lock();
        try {
            while (current != 2){
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName() + " B");
            //修改标志位
            current = 3;
            //唤醒
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try {
            while (current != 3){
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName() + " C");
            //修改标志位
            current = 1;
            //唤醒
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}