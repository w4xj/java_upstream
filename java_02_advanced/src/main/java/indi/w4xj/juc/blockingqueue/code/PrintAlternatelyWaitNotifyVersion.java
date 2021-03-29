package indi.w4xj.juc.blockingqueue.code;

import java.util.PrimitiveIterator;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.blockingqueue.code
 * @Classname ProducerConsumerWaitNotifyVersion
 * @Description TODO
 * @Date 2021/3/29 23:02
 * @Created by IntelliJ IDEA
 */
public class PrintAlternatelyWaitNotifyVersion {
    public static void main(String[] args) {

        class Printer implements Runnable{
            int num;
            public Printer(int num) {
                this.num = num;
            }
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (Printer.class){
                        Printer.class.notify();
                        System.out.println(num);
                        if( i < 5){
                            try { Printer.class.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
                        }
                    }
                }
            }
        }

        new Thread(new Printer(1)).start();
        new Thread(new Printer(0)).start();

    }
}
