package indi.w4xj.juc.container.code;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.container.code
 * @Classname HashSetNoSafe
 * @Description 
 * @Date 2021/2/13 13:15
 * @Created by IntelliJ IDEA
 */
public class HashSetNotSafe {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        for (int i = 0 ; i < 30 ; i++){
            new Thread(() ->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            },"threadName" + i).start();
        }
    }
}
