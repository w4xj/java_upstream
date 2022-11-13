package indi.w4xj.juc.blockingqueue.code;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.blockingqueue.code
 * @Classname SynchronousQueueTest
 * @Description 
 * @Date 2021/2/14 14:28
 * @Created by IntelliJ IDEA
 */
public class SynchronousQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() ->{
            try {
                System.out.println(Thread.currentThread().getName() + " put a");
                blockingQueue.put("a");

                System.out.println(Thread.currentThread().getName() + " put b");
                blockingQueue.put("b");

                System.out.println(Thread.currentThread().getName() + " put c");
                blockingQueue.put("c");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"ThreadA").start();

        new Thread(() ->{
            try {
                //线程睡1秒
                try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + " get " + blockingQueue.take());

                //线程睡1秒
                try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + " get " + blockingQueue.take());

                //线程睡1秒
                try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName() + " get " + blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"ThreadB").start();

        /*
        打印：
            ThreadA put a
            ThreadB get a
            ThreadA put b
            ThreadB get b
            ThreadA put c
            ThreadB get c
         */
    }
}
