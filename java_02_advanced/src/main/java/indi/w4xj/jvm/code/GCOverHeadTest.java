package indi.w4xj.jvm.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname GCOverHeadTest
 * @Description TODO
 * @Date 2021/2/16 11:57
 * @Created by IntelliJ IDEA
 */
public class GCOverHeadTest {
    public static void main(String[] args) {
        int i = 0;
        List<String> list =  new ArrayList<>();
        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        }catch (Throwable e){
            System.out.println("i: " + i);
            e.printStackTrace();
        }


    }
}