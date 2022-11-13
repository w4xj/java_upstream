package indi.w4xj.juc.container.code;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.container.code
 * @Classname HashMapNotSafe
 * @Description 
 * @Date 2021/2/13 13:41
 * @Created by IntelliJ IDEA
 */
public class HashMapNotSafe {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        for (int i = 0 ; i < 30 ; i++){
            new Thread(() ->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },"threadName" + i).start();
        }
    }
}
