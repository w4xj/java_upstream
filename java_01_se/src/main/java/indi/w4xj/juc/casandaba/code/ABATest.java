package indi.w4xj.juc.casandaba.code;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.casandaba.code
 * @Classname ABATest
 * @Description 
 * @Date 2021/2/12 12:00
 * @Created by IntelliJ IDEA
 */
public class ABATest {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    public static void main(String[] args) {

        new Thread(() ->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"threadName1").start();


        new Thread(() ->{
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicReference.compareAndSet(100, 101) + " : " + atomicReference.get());
        },"threadName2").start();

    }
}
