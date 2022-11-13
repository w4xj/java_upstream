package indi.w4xj.juc.threadpool.code;

import javax.xml.transform.Result;
import java.util.concurrent.*;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.threadpool.code
 * @Classname CompleteFutureTest1
 * @Description 
 * @Date 2022/11/5 17:11
 * @Created by IntelliJ IDEA
 */
public class CompleteFutureTest1 {
    public static void main(String[] args) {
        before();
        System.out.println("-------------");
        after();


    }

    private static void after() {
        //这里如果不创建线程池，会用默认的线程池，那么会出现默认线程池随主线程关闭的情况，所以这里要显示指定线程池，最好是手动new，不用默认的
        ExecutorService pool = Executors.newFixedThreadPool(3);
        CompletableFuture.supplyAsync(() -> {
//            Thread.sleep(3000);
            int i = 1 / 0;
            return "callable";
        }, pool).whenComplete((a, b) -> {//a为异步执行的返回值，b是异常，不管是否异常都会执行whenComplete
            System.out.println(a);
            System.out.println(b);
        }).exceptionally(e -> {//异常会执行exceptionally
            System.out.println(e.getMessage());
            return e.getMessage();
        });

        pool.shutdown();


    }

    private static void before() {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        FutureTask<String> futureTask = new FutureTask<>(() -> {
//            Thread.sleep(3000);
//            int a = 1/0;
            return "callable";
        });
        pool.execute(futureTask);
        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        pool.shutdown();
    }
}
