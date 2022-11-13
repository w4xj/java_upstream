package indi.w4xj.juc.threadpool.code;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.threadpool.code
 * @Classname CallableTest
 * @Description 
 * @Date 2021/2/15 10:16
 * @Created by IntelliJ IDEA
 */
public class CallableTest {
    public static void main(String[] args) throws Exception{
        Callable<String> callable = new CallableThread();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        new Thread(futureTask, "ThreadA").start();
        new Thread(futureTask, "ThreadB").start();

        //futureTask.get()最好放在后面，因为这个操作会阻塞main线程（当前调用这个方法的线程），也可以使用futureTask.isDone()自旋锁判断
        System.out.println(futureTask.get());
        /*
        打印：
            ThreadA invoke call method 或  ThreadB invoke call method
            hello callable
         */
    }
}

/**
 * 实现Callable接口
 */
class CallableThread implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println( Thread.currentThread().getName() + " invoke call method");
        return "hello callable";
    }
}
