package indi.w4xj.juc.threadpool.code;

import java.util.concurrent.*;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.threadpool.code
 * @Classname FutureTest
 * @Description
 * @Date 2021/4/11 14:20
 * @Created by IntelliJ IDEA
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(1);

        //<T> Future<T> submit(Callable<T> task);
        Future<String> future = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "future";
        });

        System.out.println(future.get());
        System.out.println(future.isDone());
    }
}
