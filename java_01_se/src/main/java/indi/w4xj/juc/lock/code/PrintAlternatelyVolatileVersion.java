package indi.w4xj.juc.lock.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.blockingqueue.code
 * @Classname ProducerConsumerSynchronizedVersion
 * @Description 
 * @Date 2021/2/14 14:50
 * @Created by IntelliJ IDEA
 */
public class PrintAlternatelyVolatileVersion {
    public static void main(String[] args) {
        SyncResource syncResource = new SyncResource();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                syncResource.increment();
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                syncResource.decrement();
            }
        }).start();
    }
}

class SyncResource{
    //这里的volatile必须要加，不然线程之间的可见性无法保证，有可能出现在while处死循环
    private volatile int number = 0;
    public void increment(){

        while(number != 0){}
        //这里其实可以不用synchronized，synchronized这里只是单纯保证打印0和1的顺序
        //出现不严格的01排列，如 0101001110，但这并不是0、1打印顺序错误，而是因为控制台的System.out.println并不同步
        //加synchronized只是在控制台打印看起来是0101010101
        synchronized (SyncResource.class){
            System.out.println(number++);
        }

    }

    public void decrement(){
        while(number != 1){}
        synchronized (SyncResource.class){
            System.out.println(number--);
        }
    }
}

