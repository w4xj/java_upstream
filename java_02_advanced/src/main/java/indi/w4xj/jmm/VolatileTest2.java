package indi.w4xj.jmm;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jmm
 * @Classname VolatileTest2
 * @Description volatile无法保证原子性
 * @Date 2021/1/22 13:52
 * @Created by IntelliJ IDEA
 */
public class VolatileTest2 {
    public static void main(String[] args) {
        Data2 data = new Data2();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    data.plus();
                }
            }, String.valueOf(i)).start();
        }

        //2即代表gc线程和main线程
        while (Thread.activeCount() > 2){
            //让出线程执行权
            Thread.yield();
        }
        //输出总是小于2000
        System.out.println(Thread.currentThread().getName() +" : "+ data.num);
    }
}

class Data2 {
    //volatile 关键字就可以保证可见性，若不加这个关键字，主线程是收不到AAA线程修改num变量成功的通知的
    volatile int num = 0;

    public void plus() {
        //这里睡1毫秒，让这个加塞出现的更明显一些，因为自增这个操作太快了，同样也是因为线程速度过快，会导致可见性来不及通知所以导致写被覆盖，无法保证原子性
        try {
            Thread.currentThread().sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num++;
    }
}