package indi.w4xj.jmm.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jmm.code
 * @Classname DoubleCheckLock
 * @Description
 * @Date 2021/2/9 16:43
 * @Created by IntelliJ IDEA
 */
public class DoubleCheckLock {

    private static DoubleCheckLock instance;

    private DoubleCheckLock(){}

    public static DoubleCheckLock getInstance(){

        //第一次检测
        if (instance == null){
            //同步
            synchronized (DoubleCheckLock.class){
                if (instance == null){
                    //多线程环境下可能会出现问题的地方
                    instance = new DoubleCheckLock();
                }
            }
        }
        return instance;
    }
}
