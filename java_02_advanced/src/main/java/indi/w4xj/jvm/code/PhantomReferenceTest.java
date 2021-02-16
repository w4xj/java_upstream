package indi.w4xj.jvm.code;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname PhantomReferenceTest
 * @Description TODO
 * @Date 2021/2/16 11:42
 * @Created by IntelliJ IDEA
 */
public class PhantomReferenceTest {
    public static void main(String[] args) {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        Object object = new Object();
        PhantomReference<Object> phantomReference = new PhantomReference<>(object, referenceQueue);


        System.out.println(object);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());


        System.out.println("-----------------------");
        System.gc();
        System.out.println(object);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
    }
}
