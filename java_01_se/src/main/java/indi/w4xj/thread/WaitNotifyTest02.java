package indi.w4xj.thread;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.thread
 * @Classname WaitNotifyTest02
 * @Description 交替打印0和1
 * @Date 2021/3/29 22:42
 * @Created by IntelliJ IDEA
 */
public class WaitNotifyTest02 {


    public static void main(String[] args) {
        class Resource implements Runnable{
            int i = 0;
            @Override
            public void run() {
                while(i<100) {
                    synchronized (Resource.class) {
                        Resource.class.notify();
                        System.out.println(Thread.currentThread().getName() + ":\t" + (++i));
                        if(i < 100){
                            try {
                                Resource.class.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        Runnable runnable = new Resource();
        Thread t1 = new Thread(runnable,"A");
        Thread t2 = new Thread(runnable,"B");
        t1.start();
        t2.start();
    }
}
