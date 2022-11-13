package indi.w4xj.jvm.code;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname ReferenceQueueTest
 * @Description 
 * @Date 2021/2/16 11:40
 * @Created by IntelliJ IDEA
 */
public class ReferenceQueueTest {
    public static void main(String[] args) {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        Object object = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(object, referenceQueue);


        System.out.println(object);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());
        System.out.println("----------------------------");


        object = null;
        System.gc();


        System.out.println(object);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());


    }
}
