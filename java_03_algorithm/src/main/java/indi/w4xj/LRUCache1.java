package indi.w4xj;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj
 * @Classname LRUCache
 * @Description TODO
 * @Date 2021/3/4 22:00
 * @Created by IntelliJ IDEA
 *
 * 146题
 */
public class LRUCache1<K, V> extends LinkedHashMap<K, V> {

    private int capacity;
    private boolean accessOrder;

    public LRUCache1(int capacity, boolean accessOrder){
        /**
         * @param  initialCapacity the initial capacity
         * @param  loadFactor      the load factor
         * @param  accessOrder     the ordering mode -
         *                        <tt>true</tt> for  access-order, 访问顺序
         *                        <tt>false</tt> for insertion-order  插入顺序
         */
        super(capacity, 0.75F, accessOrder);
        this.capacity = capacity;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > this.capacity;
    }

    public int get(int key){
        return 0;
    }


    public void put(int key, int value){

    }


    public static void main(String[] args) {
        LRUCache1<String, String> accessOrderMap = new LRUCache1<>(3,true);
        accessOrderMap.put("1","a");
        accessOrderMap.put("2","b");
        accessOrderMap.put("3","c");
        accessOrderMap.put("4","d");
        System.out.println(accessOrderMap.keySet());
        accessOrderMap.put("3","c");
        System.out.println(accessOrderMap.keySet());
        accessOrderMap.put("3","c");
        System.out.println(accessOrderMap.keySet());
        accessOrderMap.put("3","c");
        System.out.println(accessOrderMap.keySet());
        accessOrderMap.put("5","e");
        System.out.println(accessOrderMap.keySet());
        System.out.println("----------------------------");
        LRUCache1<String, String> insertionOrderMap = new LRUCache1<>(3,true);
        insertionOrderMap.put("1","a");
        insertionOrderMap.put("2","b");
        insertionOrderMap.put("3","c");
        insertionOrderMap.put("4","d");
        System.out.println(insertionOrderMap.keySet());
        insertionOrderMap.put("3","c");
        System.out.println(insertionOrderMap.keySet());
        insertionOrderMap.put("3","c");
        System.out.println(insertionOrderMap.keySet());
        insertionOrderMap.put("3","c");
        System.out.println(insertionOrderMap.keySet());
        insertionOrderMap.put("5","e");
        System.out.println(insertionOrderMap.keySet());

        /**
         结果
             [2, 3, 4]
             [2, 4, 3]

             [2, 4, 3]
             [2, 4, 3]
             [4, 3, 5]
             ----------------------------
             [2, 3, 4]
             [2, 4, 3]

             [2, 4, 3]
             [2, 4, 3]
             [4, 3, 5]

         */
    }
}
