package indi.w4xj.jvm.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname ClassLoadingProcedure
 * @Description TODO
 * @Date 2021/5/9 15:21
 * @Created by IntelliJ IDEA
 */
public class ClassLoadingProcedure {

    public static void main(String[] args) {
        System.out.println(T1.count);
        System.out.println("---------------");
        System.out.println(T2.count);
    }
}

class T1 {
    /**
     Preparation阶段：
     public static T1 t = new T1();
        t      null
     public static int count = 2;
        count  0
     Initializing阶段：
     public static T1 t = new T1();
         t      new T1()
         count  1
     public static int count = 2;
        count  2
     */
    public static T1 t = new T1();
    public static int count = 2;
    private T1() {
        count++;
        //System.out.println("--" + count);
    }
}

class T2 {
    /**
     Preparation阶段：
     public static int count = 2;
     count  0
     public static T2 t = new T2();
     t      null
     Initializing阶段：
     public static int count = 2;
     count  2
     public static T2 t = new T2();
     t      new T2()
     count  3
     */
    public static int count = 2;
    public static T2 t = new T2();

    private T2() {
        count++;
        //System.out.println("--" + count);
    }
}

