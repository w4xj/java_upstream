package indi.w4xj.jvm.code;

import java.util.concurrent.TimeUnit;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname UnableToCreateNewNativeThreadTest
 * @Description 
 * @Date 2021/2/16 13:15
 * @Created by IntelliJ IDEA
 */
public class UnableToCreateNewNativeThreadTest {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            new Thread(() ->{
                //线程睡1秒
                try { TimeUnit.SECONDS.sleep(Integer.MAX_VALUE); } catch (InterruptedException e) { e.printStackTrace(); }
            },"threadName" + (++i)).start();
        }
    }
}
