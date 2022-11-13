package indi.w4xj.juc.casandaba.code;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.casandaba.code
 * @Classname ABAResolve
 * @Description 
 * @Date 2021/2/12 12:34
 * @Created by IntelliJ IDEA
 */
public class ABAResolve {
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);
    public static void main(String[] args) {
        new Thread(() ->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println("第一次：值 = " + atomicStampedReference.getReference() + ", 版本号 = " + stamp);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("修改结果：" + atomicStampedReference.compareAndSet(100, 101, stamp, ++stamp));
            System.out.println("第二次：值 = " + atomicStampedReference.getReference() + ", 版本号 = " + atomicStampedReference.getStamp());
            System.out.println("修改结果：" + atomicStampedReference.compareAndSet(101, 100, stamp, ++stamp));
            System.out.println("第三次：值 = " + atomicStampedReference.getReference() + ", 版本号 = " + atomicStampedReference.getStamp());
        },"threadName1").start();

        new Thread(() ->{
            int stamp = atomicStampedReference.getStamp();
            try {
                Thread.currentThread().sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("修改结果：" + atomicStampedReference.compareAndSet(100, 999, stamp, ++stamp));
            System.out.println("第四次：值 = " + atomicStampedReference.getReference() + ", 版本号 = " + atomicStampedReference.getStamp());
        },"threadName2").start();

        /*
        打印：
            第一次：值 = 100, 版本号 = 1
            修改结果：true
            第二次：值 = 101, 版本号 = 2
            修改结果：true
            第三次：值 = 100, 版本号 = 3
            修改结果：false
            第四次：值 = 100, 版本号 = 3
         */

    }
}
