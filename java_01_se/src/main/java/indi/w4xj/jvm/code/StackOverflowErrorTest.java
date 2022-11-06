package indi.w4xj.jvm.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname StackOverflowErrorTest
 * @Description TODO
 * @Date 2021/2/16 11:51
 * @Created by IntelliJ IDEA
 */
public class StackOverflowErrorTest {
    public static void main(String[] args) {
        method();
    }

    private static void method(){
        /*
            Exception in thread "main" java.lang.StackOverflowError
                at indi.w4xj.jvm.code.StackOverflowErrorTest.method(StackOverflowErrorTest.java:24)
                ...
            Process finished with exit code 1
         */
        method();
    }
}
