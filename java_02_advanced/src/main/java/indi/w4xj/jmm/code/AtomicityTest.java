package indi.w4xj.jmm.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jmm
 * @Classname AtomicityTest
 * @Description
 * @Date 2021/2/5 13:21
 * @Created by IntelliJ IDEA
 */
public class AtomicityTest {
    volatile int number;
    public void add(){
        number++;
    }
}
