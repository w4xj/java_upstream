package indi.w4xj.juc.blockingqueue.code;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.blockingqueue.code
 * @Classname ThrowExceptionBlockingQueueMethod
 * @Description 
 * @Date 2021/2/14 14:10
 * @Created by IntelliJ IDEA
 */
public class ThrowExceptionBlockingQueueMethod {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        //Exception in thread "main" java.lang.IllegalStateException: Queue full
        //System.out.println(blockingQueue.add("z"));
        //队列头元素
        blockingQueue.element();

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        //java.util.NoSuchElementException
        //System.out.println(blockingQueue.remove());
    }
}
