package indi.w4xj.jvm.code;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname WeakHashMapTest
 * @Description 
 * @Date 2021/2/16 11:37
 * @Created by IntelliJ IDEA
 */
public class WeakHashMapTest {
    public static void main(String[] args) {
        hashMap();
        System.out.println("======================================");
        weakHashMap();
    }

    private static void hashMap() {
        Map<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = new String("HashMap");
        map.put(key, value);
        key = null;
        System.gc();
        System.out.println(map);
    }

    private static void weakHashMap() {
        Map<Integer, String> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = new String("WeakHashMap");
        map.put(key, value);
        key = null;
        System.gc();
        System.out.println(map);
    }
}
