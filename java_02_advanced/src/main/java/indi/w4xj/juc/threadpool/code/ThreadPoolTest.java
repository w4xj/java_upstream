package indi.w4xj.juc.threadpool.code;

import java.util.concurrent.*;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.threadpool.code
 * @Classname ThreadPoolTest
 * @Description TODO
 * @Date 2021/2/15 11:28
 * @Created by IntelliJ IDEA
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                final int num = i;
                pool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " " + num);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}