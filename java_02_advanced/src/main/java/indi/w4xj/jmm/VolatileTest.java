package indi.w4xj.jmm;

import java.util.concurrent.TimeUnit;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jmm
 * @Classname VolatileTest
 * @Description volatile可以保证可见性
 * @Date 2021/1/22 10:22
 * @Created by IntelliJ IDEA
 */
public class VolatileTest {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + "\t thread begin");
            try {
                //让AAA线程睡3秒，让主线程获取到执行权执行到 while (data.num == 0){}
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.setNum();
            System.out.println(Thread.currentThread().getName() + "\t updated num value: " + data.num);
        },"AAA").start();
        //当
        while (data.num == 0){}
        System.out.println(Thread.currentThread().getName() + "\t update is over, the num is " + data.num);
    }
}
class Data{
    //volatile 关键字就可以保证可见性，若不加这个关键字，主线程是收不到AAA线程修改num变量成功的通知的，主线程会在while (data.num == 0){}死循环
    volatile int num = 0;
    public void setNum(){
        this.num = 66;
    }
}
