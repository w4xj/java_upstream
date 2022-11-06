package indi.w4xj.jmh.code;


import org.openjdk.jmh.annotations.*;

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
    //预热 ； iterations：次数， time：时间
    @Warmup(iterations = 1, time = 3)
    //用短少线程执行
    @Fork(5)
    /**
     * 模式：吞吐量
     * Throughput("thrpt", "Throughput, ops/time"),
     * AverageTime("avgt", "Average time, time/op"),
     * SampleTime("sample", "Sampling time"),
     * SingleShotTime("ss", "Single shot invocation time"),
     * All("all", "All benchmark modes");
     */
    @BenchmarkMode(Mode.Throughput)
    //总共执行多少次测试
    @Measurement(iterations = 1, time = 3)
    public void testForEach() {
        JmhBizClass.foreach();
    }
}
