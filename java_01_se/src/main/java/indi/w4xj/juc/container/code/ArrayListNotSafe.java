package indi.w4xj.juc.container.code;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.container.code
 * @Classname ArrayListTest1
 * @Description 
 * @Date 2021/2/13 11:58
 * @Created by IntelliJ IDEA
 */
public class ArrayListNotSafe {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0 ; i < 30 ; i++){
            new Thread(() ->{
                list.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(list);
            },"threadName" + i).start();
        }
    }
}
