package indi.w4xj.juc.threadpool.code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.threadpool.code
 * @Classname ThreadPoolTest
 * @Description 
 * @Date 2021/2/15 11:08
 * @Created by IntelliJ IDEA
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        //ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                final int num = i;
                executorService.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " " + num);
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
