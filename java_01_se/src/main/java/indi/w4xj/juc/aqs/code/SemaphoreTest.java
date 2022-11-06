package indi.w4xj.juc.aqs.code;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.aqs.code
 * @Classname SemaphoreTest
 * @Description TODO
 * @Date 2021/2/14 12:50
 * @Created by IntelliJ IDEA
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        //初始化信号量大小
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1 ; i <= 6 ; i++){
            new Thread(() ->{
                try {
                    //抢占资源，资源数-1
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "号车抢到车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName() + "号车停车1秒，开出车位");
                    //释放资源,资源数+1
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
        /*
        打印：
            1号车抢到车位
            2号车抢到车位
            3号车抢到车位
            1号车停车1秒，开出车位
            4号车抢到车位
            2号车停车1秒，开出车位
            5号车抢到车位
            3号车停车1秒，开出车位
            6号车抢到车位
            4号车停车1秒，开出车位
            5号车停车1秒，开出车位
            6号车停车1秒，开出车位
         */
    }
}
