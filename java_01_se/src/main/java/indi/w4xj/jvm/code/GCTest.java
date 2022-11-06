package indi.w4xj.jvm.code;

import java.util.Random;
import java.util.UUID;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname GCTest
 * @Description TODO
 * @Date 2021/2/16 13:30
 * @Created by IntelliJ IDEA
 *
 *
 * 1.DefNew + Tenured
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialGC
 * 2.ParNew + Tenured
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParNewGC
 * 3.PSYoungGen + ParOldGen
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelGC
 * 4.PSYoungGen + ParOldGen
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseParallelOldGC
 * 5.par new generation + concurrent mark-sweep
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC
 * 6.java8中已经没有了，运行报错
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseSerialOldGC
 * 7.G1
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseG1GC
 */
public class GCTest {
    public static void main(String[] args) {
        String str = "aaa";
        while (true){
            str += str + UUID.randomUUID().toString() + new Random().nextInt(777777) + UUID.randomUUID().toString() + new Random().nextInt(12343);
            str.intern();
        }
    }
}
