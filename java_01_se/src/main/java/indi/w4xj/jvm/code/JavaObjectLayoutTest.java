package indi.w4xj.jvm.code;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname JavaObjectLayoutTest
 * @Description TODO
 * @Date 2022/11/6 12:15
 * @Created by IntelliJ IDEA
 */
public class JavaObjectLayoutTest {
    public static void main(String[] args) {
        Object object = new Object();
        A a = new A();
        int[] ints = new int[0];
//        System.out.println(ClassLayout.parseInstance(object).toPrintable());
//        System.out.println(ClassLayout.parseInstance(a).toPrintable());
        System.out.println(ClassLayout.parseInstance(ints).toPrintable());
    }
}
class A{
    short id;
    String name;
}
