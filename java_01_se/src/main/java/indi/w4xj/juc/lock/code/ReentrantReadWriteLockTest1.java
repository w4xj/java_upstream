package indi.w4xj.juc.lock.code;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.lock.code
 * @Classname ReentrantReadWriteLockTest1
 * @Description 
 * @Date 2021/2/13 14:43
 * @Created by IntelliJ IDEA
 */
public class ReentrantReadWriteLockTest1 {
    public static void main(String[] args) {
        Cache cache1 = new Cache();
        Cache cache2 = new Cache();

        //cache1会产生写争抢，因为没有加锁
        for (int i = 0; i < 4; i++) {
            final String key = String.valueOf(i);
            final Integer value = i;
            new Thread(() -> {
                cache1.put1(key, value);
            }, "threadName" + i).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        for (int i = 0; i < 4; i++) {
            final String key = String.valueOf(i);
            new Thread(() -> {
                cache1.get1(key);
            }, "threadName" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------------");

        //cache2不会会产生写争抢，因为put方法加了write锁
        for (int i = 10; i < 14; i++) {
            final String key = String.valueOf(i);
            final Integer value = i;
            new Thread(() -> {
                cache2.put2(key, value);
            }, "threadName" + i).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        for (int i = 10; i < 14; i++) {
            final String key = String.valueOf(i);
            new Thread(() -> {
                cache2.get2(key);
            }, "threadName" + i).start();
        }

        /*
        打印：
            threadName0	 正在写入(0,0)
            threadName3	 正在写入(3,3)
            threadName2	 正在写入(2,2)
            threadName1	 正在写入(1,1)
            threadName1	 写入(1,1)完成
            threadName0	 写入(0,0)完成
            threadName2	 写入(2,2)完成
            threadName3	 写入(3,3)完成
            threadName0	 正在读取0
            threadName1	 正在读取1
            threadName2	 正在读取2
            threadName3	 正在读取3
            threadName2	 读取(2,null)完成
            threadName3	 读取(3,null)完成
            threadName1	 读取(1,1)完成
            threadName0	 读取(0,0)完成
            --------------------------------------
            threadName10	 正在写入(10,10)
            threadName10	 写入(10,10)完成
            threadName12	 正在写入(12,12)
            threadName12	 写入(12,12)完成
            threadName11	 正在写入(11,11)
            threadName11	 写入(11,11)完成
            threadName13	 正在写入(13,13)
            threadName13	 写入(13,13)完成
            threadName10	 正在读取10
            threadName13	 正在读取13
            threadName11	 正在读取11
            threadName12	 正在读取12
            threadName10	 读取(10,10)完成
            threadName12	 读取(12,12)完成
            threadName13	 读取(13,13)完成
            threadName11	 读取(11,11)完成

         */

    }
}

class Cache {
    private volatile Map<String, Object> map = new HashMap<>();

    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put1(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "\t 正在写入(" + key + "," + value + ")");
        //睡0.1秒
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "\t 写入(" + key + "," + value + ")完成");
    }

    public void get1(String key) {
        System.out.println(Thread.currentThread().getName() + "\t 正在读取" + key + "");
        //睡0.1秒
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object value = map.get(key);
        System.out.println(Thread.currentThread().getName() + "\t 读取(" + key + "," + value + ")完成");
    }

    public void put2(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入(" + key + "," + value + ")");
            //睡0.1秒
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入(" + key + "," + value + ")完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get2(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取" + key + "");
            //睡0.1秒
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Object value = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取(" + key + "," + value + ")完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}