package indi.w4xj.juc.threadpool.code;

import java.util.concurrent.*;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.threadpool.code
 * @Classname FutrureTaskTest
 * @Description 
 * @Date 2021/4/11 14:26
 * @Created by IntelliJ IDEA
 */
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //作为
        FutureTask futureTask1 = new FutureTask(() -> {
            return "futureTask";
        });
        new Thread(futureTask1).start();
        System.out.println(futureTask1.get());
        System.out.println(futureTask1.isDone());



        ExecutorService service = Executors.newFixedThreadPool(1);
        FutureTask futureTask2 = new FutureTask(() -> {
            return "futureTask";
        });
        Future future = service.submit(futureTask2);

        System.out.println(future.get());
        System.out.println(futureTask2.get());
        System.out.println(futureTask2.isDone());
        service.shutdown();


    }
}
