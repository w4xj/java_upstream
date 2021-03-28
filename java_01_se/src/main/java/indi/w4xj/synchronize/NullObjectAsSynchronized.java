package indi.w4xj.synchronize;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.thread
 * @Classname NullObjectAsSynchronized
 * @Description TODO
 * @Date 2021/3/28 13:02
 * @Created by IntelliJ IDEA
 */
public class NullObjectAsSynchronized {
    public static void main(String[] args) {
        Object o = null;
        //java.lang.NullPointerException
        synchronized (o){
            System.out.println(1);
        }
    }

}
