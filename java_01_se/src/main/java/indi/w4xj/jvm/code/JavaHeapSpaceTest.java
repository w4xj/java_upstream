package indi.w4xj.jvm.code;

import java.util.UUID;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname JavaHeapSpaceTest
 * @Description
 * @Date 2021/2/16 11:54
 * @Created by IntelliJ IDEA
 */
public class JavaHeapSpaceTest {
    public static void main(String[] args) {
        String str = "";
        //为了效果明显最好将Xms和Xmx调小
        while (true) {
            str += UUID.randomUUID().toString() + UUID.randomUUID().toString() + UUID.randomUUID().toString().intern();
        }
        /*
        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
            at java.util.Arrays.copyOf(Arrays.java:3332)
            at java.lang.AbstractStringBuilder.ensureCapacityInternal(AbstractStringBuilder.java:124)
            at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:448)
            at java.lang.StringBuilder.append(StringBuilder.java:136)
            at com.w4xj.interview.jvmgc.JavaHeapSpace.main(JavaHeapSpace.java:19)
         */
    }
}
