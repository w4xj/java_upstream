package indi.w4xj.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.thread
 * @Classname WhatIsThread
 * @Description 
 * @Date 2021/3/27 23:19
 * @Created by IntelliJ IDEA
 */
public class WhatIsThread {
    private static class T1 extends Thread{
        @Override
        public void run() {
            try {
                TimeUnit.MICROSECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName());
        }

        public static void main(String[] args) {
            //run 和 start的区别：
            //run会在主线程中执行，不会新开线程，因为它只是一个普通的方法
            //start则是会在新的线程中执行run方法
            new T1().run();
            new T1().start();
            System.out.println(Thread.currentThread().getName());
        }
    }
}
