package indi.w4xj.jmh.code;

import org.openjdk.jmh.annotations.Benchmark;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jmh.test
 * @Classname JmhTest
 * @Description TODO
 * @Date 2021/4/15 21:57
 * @Created by IntelliJ IDEA
 */
public class JmhTest {

    @Benchmark
    public void testForEach() {
        JmhBizClass.foreach();
    }
}
