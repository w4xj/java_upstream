package indi.w4xj.thread;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.thread
 * @Classname WaitNotifyTest
 * @Description 
 * @Date 2021/3/29 22:27
 * @Created by IntelliJ IDEA
 */
public class WaitNotifyTest {
    public static void main(String[] args) {
        Object o = new Object();
        new Thread(() -> {
            synchronized (o){
                try {
                    o.wait();
                    System.out.println("---------------");
                    o.notify();
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        },"B").start();

        new Thread(() -> {
            synchronized (o){
                for (int i = 1; i <= 10; i++){
                    System.out.println(i);
                    if (i == 5){
                        try { o.notify();o.wait(); } catch (InterruptedException e) { e.printStackTrace(); }
                    }
                }
            }
        },"A").start();
    }
}
