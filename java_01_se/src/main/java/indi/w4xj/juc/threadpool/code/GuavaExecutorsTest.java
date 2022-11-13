package indi.w4xj.juc.threadpool.code;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.threadpool.code
 * @Classname ExecutorsDemo
 * @Description 
 * @Date 2021/2/15 11:33
 * @Created by IntelliJ IDEA
 */
public class GuavaExecutorsTest {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();

    private static ExecutorService pool = new ThreadPoolExecutor(5, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    public static void main(String[] args) {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            //pool.execute(new SubThread());
            pool.execute(()->{

            });
        }
    }
}
