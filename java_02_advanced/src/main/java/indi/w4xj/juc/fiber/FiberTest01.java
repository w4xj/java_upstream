//package indi.w4xj.juc.fiber;
//
//
//import co.paralleluniverse.fibers.Fiber;
//import co.paralleluniverse.fibers.SuspendExecution;
//import co.paralleluniverse.strands.SuspendableCallable;
//
///**
// * @Author lemon joker
// * @Project java_upstream
// * @Package indi.w4xj.juc.fiber
// * @Classname FiberTest01
// * @Description 测试纤程
// * @Date 2021/5/22 17:29
// * @Created by IntelliJ IDEA
// */
//public class FiberTest01 {
//    public static void main(String[] args) {
//        thread();
//    }
//
//
//    //使用   -javaagent:D:/DevTools/RepMaven/co/paralleluniverse/quasar-core/0.8.0/quasar-core-0.8.0.jar
//    private static void fiber() {
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10_0000; i++) {
//            Fiber<Void> fiber = new Fiber<Void>(new SuspendableCallable() {
//                @Override
//                public Object run() throws SuspendExecution, InterruptedException {
//                    int m = 0;
//                    for (int j = 0; j< 1_0000; j++){
//                        m += j;
//                    }
//                    return null;
//                }
//            });
//
//            fiber.start();
//        }
//
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
//    }
//
//    private static void thread() {
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10_0000; i++) {
//
//            new Thread(()->{
//                int m = 0;
//                for (int j = 0; j< 10000; j++){
//                    m += j;
//                }
//            }).start();
//        }
//
//        while(Thread.activeCount() > 2){
//            Thread.yield();
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
//    }
//
//
//}
