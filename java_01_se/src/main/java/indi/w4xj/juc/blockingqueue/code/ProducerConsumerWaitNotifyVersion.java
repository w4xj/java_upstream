package indi.w4xj.juc.blockingqueue.code;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.blockingqueue.code
 * @Classname ProducerConsumerWaitNotifyVersion
 * @Description 
 * @Date 2021/3/30 22:12
 * @Created by IntelliJ IDEA
 */
public class ProducerConsumerWaitNotifyVersion<T> {
    final private LinkedList<T> lists = new LinkedList<>();
    final private int MAX = 10; //最多10个元素
    private int count = 0;


    public synchronized void put(T t) {
        while(lists.size() == MAX) { //想想为什么用while而不是用if？
            try {
                this.wait(); //effective java
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        lists.add(t);
        ++count;
        this.notifyAll(); //通知消费者线程进行消费
    }

    public synchronized T get() {
        T t = null;
        while(lists.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = lists.removeFirst();
        count --;
        this.notifyAll(); //通知生产者进行生产
        return t;
    }

    public static void main(String[] args) {
        ProducerConsumerWaitNotifyVersion<String> c = new ProducerConsumerWaitNotifyVersion<>();
        //启动消费者线程
        for(int i=0; i<10; i++) {
            new Thread(()->{
                for(int j=0; j<5; j++) System.out.println(c.get());
            }, "c" + i).start();
        }

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //启动生产者线程
        for(int i=0; i<2; i++) {
            new Thread(()->{
                for(int j=0; j<25; j++) c.put(Thread.currentThread().getName() + " " + j);
            }, "p" + i).start();
        }
    }
}
