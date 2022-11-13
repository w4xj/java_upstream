package indi.w4xj.juc.container.code;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.container.code
 * @Classname ConcurrentLinkedQueueTest
 * @Description 
 * @Date 2021/4/5 11:25
 * @Created by IntelliJ IDEA
 */
public class ConcurrentLinkedQueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new ConcurrentLinkedQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.add("No."+i);
        }
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    String ticket = queue.poll();
                    if (null == ticket) {
                        System.out.println("sold out...");
                        break;
                    }
                    System.out.println(Thread.currentThread().getName()+" sold: " + ticket);
                }
            },"Thread"+i).start();
        }
    }
}
