package indi.w4xj.juc.blockingqueue.code;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.blockingqueue.code
 * @Classname ProducerConsumerBlockingQueueVersion
 * @Description TODO
 * @Date 2021/2/14 16:28
 * @Created by IntelliJ IDEA
 */
public class ProducerConsumerBlockingQueueVersion {
    public static void main(String[] args) {
        CakeResouce cakeResouce = new CakeResouce(new ArrayBlockingQueue<String>(3));

        new Thread(() -> {
            try {
                cakeResouce.produce();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prodcuder").start();

        new Thread(() -> {
            try {
                cakeResouce.consume();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "consumer").start();

        //线程睡1秒
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cakeResouce.stopProduce();
        /*
        打印：
            prodcuder  生产1成功
            consumer   消费1成功
            consumer   消费2成功
            prodcuder  生产2成功
            consumer   消费3成功
            prodcuder  生产3成功
            prodcuder  生产4成功
            consumer   消费4成功
            prodcuder  生产5成功
            consumer   消费5成功
            main    嘿，停止生产了~~
            prodcuder   停止生产
            consumer   两秒钟未能成功消费,退出
            consumer    停止消费
         */

    }
}

class CakeResouce {
    /**
     * 线程执行标志
     * true：执行
     * false：停止
     */
    private volatile boolean currentFlag = true;

    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue<String> blockingQueue = null;


    /**
     * 构造时传入队列实例
     *
     * @param blockingQueue
     */
    public CakeResouce(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    /**
     * 生产
     *
     * @throws Exception
     */
    public void produce() throws Exception {
        String data;
        while (currentFlag) {
            data = String.valueOf(atomicInteger.incrementAndGet());
            boolean offer = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (offer) {
                System.out.println(Thread.currentThread().getName() + " \t生产" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + " \t生产" + data + "失败");
            }
            //线程睡400ms
            try {
                TimeUnit.MILLISECONDS.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "\t 停止生产");
    }

    /**
     * 消费
     *
     * @throws Exception
     */
    public void consume() throws Exception {
        String data;
        while (currentFlag) {
            String poll = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (null != poll && !"".equalsIgnoreCase(poll)) {
                System.out.println(Thread.currentThread().getName() + " \t消费" + poll + "成功");
            } else {
                currentFlag = false;
                System.out.println(Thread.currentThread().getName() + " \t两秒钟未能成功消费,退出");
            }
            //线程睡100毫秒，防止消费x打印在生产x之前
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + "\t 停止消费");
    }

    /**
     * 停止生产
     */
    public void stopProduce() {
        currentFlag = false;
        System.out.println(Thread.currentThread().getName() + "\t 嘿，停止生产了~~");
    }

}
