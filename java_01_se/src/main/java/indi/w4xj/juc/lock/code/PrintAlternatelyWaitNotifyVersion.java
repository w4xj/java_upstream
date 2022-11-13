package indi.w4xj.juc.lock.code;

import java.util.PrimitiveIterator;
import java.util.concurrent.TimeUnit;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.blockingqueue.code
 * @Classname ProducerConsumerWaitNotifyVersion
 * @Description 
 * @Date 2021/3/29 23:02
 * @Created by IntelliJ IDEA
 */
public class PrintAlternatelyWaitNotifyVersion {
    public static void main(String[] args) {

        class Printer implements Runnable{
            int num;
            int total;
            public Printer(int num, int total) {
                this.num = num;
                this.total = total;
            }
            @Override
            public void run() {
                for (int i = 0; i < total; i++) {
                    synchronized (Printer.class){
                        Printer.class.notify();
                        System.out.println(num);
                        if( i < total - 1){
                            try { Printer.class.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
                        }
                    }
                }
            }
        }

        new Thread(new Printer(1, 5)).start();
        try {
            TimeUnit.MICROSECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Printer(0, 5)).start();

    }
}
