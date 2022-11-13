package indi.w4xj.jvm.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname LazyLoading
 * @Description 
 * @Date 2021/5/6 21:59
 * @Created by IntelliJ IDEA
 */
public class LazyLoading {
    public static void main(String[] args) {
        //依次注释，只执行一个，避免相互之间的影响，看结果

        //不会打印
        //fun01();

        /*
         P
         X
         */
        //fun02();

        //不会打印
        //fun03();

        /*
         8
         */
        //fun04();

        /*
           P
           9
         */
        //fun05();


        /*
        P
         */
        fun06();


    }

    private static void fun01() {
        P p;
    }
    private static void fun02() {
        X x = new X();
    }
    private static void fun03() {
        P p;
    }
    private static void fun04() {
        System.out.println(P.i);
    }
    private static void fun05() {
        System.out.println(P.j);
    }
    private static void fun06() {
        try {
            Class.forName("indi.w4xj.jvm.code.LazyLoading$P");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static class P {
        final static int i = 8;
        static int j = 9;
        static {
            System.out.println("P");
        }
    }

    public static class X extends P {
        static {
            System.out.println("X");
        }
    }
}
