package indi.w4xj.juc.blockingqueue.code;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.blockingqueue.code
 * @Classname TimeBlockingQueue
 * @Description 
 * @Date 2021/2/14 14:18
 * @Created by IntelliJ IDEA
 */
public class TimeBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(3);
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("b", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("c", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("z", 2L, TimeUnit.SECONDS));
        /*
        打印：
            true
            true
            true
            false
         */
    }
}
