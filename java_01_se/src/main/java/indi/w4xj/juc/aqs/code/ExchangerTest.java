package indi.w4xj.juc.aqs.code;

import java.util.concurrent.Exchanger;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.aqs.code
 * @Classname ExchangerTest
 * @Description 
 * @Date 2021/3/28 19:45
 * @Created by IntelliJ IDEA
 */
public class ExchangerTest {
    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(() -> {
            String s = "T1";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t1").start();


        new Thread(() -> {
            String s = "T2";
            try {
                s = exchanger.exchange(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + s);

        }, "t2").start();


    }
}
