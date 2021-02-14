package indi.w4xj.juc.blockingqueue.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.blockingqueue.code
 * @Classname Pr
 * @Description TODO  这个到底是为什么
 * @Date 2021/2/14 15:22
 * @Created by IntelliJ IDEA
 */
public class Test {
    public static void main(String[] args) {
        Pr pr = new Pr();//资源类

        for (int i = 0; i < 2; i++) {//线程0和线程1同步执行,分别访问资源0和资源1
            new Thread(() -> {
                for (int x = 0; x < 5; x++){
                    pr.print0();
                    pr.print1();
                }
            },i+"").start();
        }
    }
}

class Pr {
    private boolean flag = true;
    public synchronized void print0() {
        if (flag) {
            notifyAll();
            System.out.println(Thread.currentThread().getName()+"******0");
            flag = false;
            try {
                wait();
                System.out.println("ok");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void print1() {
        notifyAll();
        if (!flag) {
            System.out.println(Thread.currentThread().getName()+"******1");
            flag = true;
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
