package indi.w4xj.jmm.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jmm.code
 * @Classname MixedOrder
 * @Description
 * @Date 2021/2/9 16:50
 * @Created by IntelliJ IDEA
 */
public class MixedOrder{
    int a = 0;
    boolean flag = false;
    public void writer(){
        a = 1;
        flag = true;
    }

    public void read(){
        if(flag){
            int i = a + 1;
        }
    }
}
