package indi.w4xj.juc.aqs.code;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.aqs.code
 * @Classname CyclicBarrierTest
 * @Description TODO
 * @Date 2021/2/14 12:43
 * @Created by IntelliJ IDEA
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {


        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙");
        });


        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                System.out.println("收集到第" + Thread.currentThread().getName() + "颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
        /*
        打印：
            收集到第2颗龙珠
            收集到第7颗龙珠
            收集到第6颗龙珠
            收集到第4颗龙珠
            收集到第5颗龙珠
            收集到第3颗龙珠
            收集到第1颗龙珠
            召唤神龙
         */
    }
}
