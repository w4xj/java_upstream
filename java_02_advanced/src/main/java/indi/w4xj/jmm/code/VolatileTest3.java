package indi.w4xj.jmm.code;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jmm
 * @Classname VolatileTest3
 * @Description
 * @Date 2021/2/5 13:15
 * @Created by IntelliJ IDEA
 */
public class VolatileTest3 {

    public static void main(String[] args) {
        Data3 data = new Data3();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    data.plus();
                    data.plusAtomic();
                }
            }, String.valueOf(i)).start();
        }

        //2即代表gc线程和main线程
        while (Thread.activeCount() > 2){
            //让出线程执行权
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() +" : "+ data.num);
        System.out.println(Thread.currentThread().getName() +" : "+ data.atomicInteger);
    }
}

class Data3 {
    //volatile 关键字就可以保证可见性，若不加这个关键字，主线程是收不到AAA线程修改num变量成功的通知的
    volatile int num = 0;
    //带原子性的Integer
    AtomicInteger atomicInteger = new AtomicInteger();

    public void setNum() {
        this.num = 66;
    }

    public void plus() {
        //这里睡1毫秒，让这个加塞出现的更明显一些，因为自增这个操作太快了，同样也是线程速度过快，会导致可见性来不及通知所以导致写被覆盖
        try {
            Thread.currentThread().sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num++;
    }

    public void plusAtomic() {
        try {
            Thread.currentThread().sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        atomicInteger.getAndIncrement();
    }
}
