package indi.w4xj.juc.blockingqueue.code;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.blockingqueue.code
 * @Classname SynchronusQueueTest
 * @Description 
 * @Date 2021/4/5 14:41
 * @Created by IntelliJ IDEA
 */
public class SynchronusQueueTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> strs = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);
        strs.put("a");

        System.out.println(strs.size());
    }
}

