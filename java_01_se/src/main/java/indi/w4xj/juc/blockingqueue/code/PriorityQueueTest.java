package indi.w4xj.juc.blockingqueue.code;

import java.util.PriorityQueue;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.blockingqueue.code
 * @Classname PriorityQuequeTest
 * @Description TODO
 * @Date 2021/4/5 14:25
 * @Created by IntelliJ IDEA
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();

        q.add("c");
        q.add("e");
        q.add("a");
        q.add("d");
        q.add("z");

        int size = q.size();
        for (int i = 0; i < size; i++) {
            System.out.println(q.poll());
        }
        /**
         打印：
             a
             c
             d
             e
             z
         */


    }
}
