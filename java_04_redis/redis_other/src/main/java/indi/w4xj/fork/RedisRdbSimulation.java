package indi.w4xj.fork;

import javafx.scene.shape.VLineTo;
import lombok.*;

import java.util.*;


/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.fork
 * @Classname RedisRdbSimulation
 * @Description TODO
 * @Date 2022/3/8 23:17
 * @Created by IntelliJ IDEA
 */
public class RedisRdbSimulation {

    //redis数据
    static HashMap<String, Value> redisData = new HashMap<>();
    static {
        //原始redis数据
        set("a", "abc");
        lpush("b", Arrays.asList(1,2,3));
        hset("c", new HashMap<String, Object>(){{
            put("name", "zhangsan");
            put("age", 18);
            put("sex", "male");
        }});
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Value {
        private int ref;
        private Class<?> T ;
        private Object value;
    }

    public static void main(String[] args) {
        HashMap<String, Value>  copy = new HashMap<>();
        fork(redisData, copy);
        persist(copy);
        parallelModify();

        //2即代表gc线程和main线程
        while (Thread.activeCount() > 2){
            //让出线程执行权
            Thread.yield();
        }
        System.out.println(redisData.get("a"));
        System.out.println(redisData.get("b"));
        System.out.println(redisData.get("c"));

    }

    /**
     * 模拟并发修改
     */
    private static void parallelModify() {
        //new 10 threads
        for (int i = 0 ; i < 10 ; i++){
            int finalI1 = i;
            new Thread(() ->{
                try {
                    Thread.sleep(100L);
                    set("a", "abc"+ finalI1);
                    lpush("b", Arrays.asList(finalI1));
                    hset("c", new HashMap<String, Object>(){{
                        put("i"+ finalI1, finalI1);
                    }});
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },"threadName" + i).start();
        }
    }

    /**
     * 模拟持久化
     * @param copy
     */
    private static void persist(HashMap<String, Value> copy) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "：持久化开始---------------" + new Date());
            Iterator<Map.Entry<String, Value>> iterator = copy.entrySet().iterator();
            while (iterator.hasNext()){
                try {
                    Map.Entry<String, Value> item = iterator.next();
                    System.out.println("子进程" + new Date() + "写入---\nkey=" + item.getKey() + "\nvalue=" + item.getValue() + "\n");
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            copy.clear();
            System.out.println(Thread.currentThread().getName() + "：持久化完成---------------" + new Date());
        }, "persistThread").start();
    }



    //数据存进redis
    private static void put(String key, Object value, Class<?> T) {
        Value original = redisData.get(key);
        //如果引用为2，则触发写时复制
        if(null != original && original.getRef() == 2){
            System.out.println(key);
            copyOnWrite(key, value, T);
        }else {
            redisData.put(key, new Value(1, String.class, value));
        }

    }

    /**
     * 写时复制
     * @param key
     * @param value
     * @param T
     */
    private static synchronized void copyOnWrite(String key, Object value, Class<?> T) {
        Value original = redisData.get(key);
        if(original.getRef() == 2){
            //触发写时复制
            System.out.println(Thread.currentThread().getName() + "触发写时复制\n key[" + key + "]的值从"+ original.getValue() +"改为" + value + "\n");
            redisData.put(key, new Value(1, T, value));
            original.setRef(1);
        }else{
            original.setValue(value);
        }
    }

    /**
     * 模拟String插入
     * @param key
     * @param value
     */
    private static void set(String key, String value) {
        if (value instanceof String){
            put(key, value, String.class);
        } else{
            throw new RuntimeException("只能放入String类型");
        }
    }

    /**
     * 模拟list插入
     * @param key
     * @param value
     */
    private static void lpush(String key, List value) {
        if (value instanceof List){
            redisData.put(key, new Value(1, List.class, value));
        } else{
            throw new RuntimeException("只能放入List类型");
        }
    }

    /**
     * 模拟hash插入
     * @param key
     * @param value
     */
    private static void hset(String key, Map value) {
        if (value instanceof Map){
            redisData.put(key, new Value(1, Map.class, value));
        } else{
            throw new RuntimeException("只能放入Map类型");
        }
    }


    /**
     * redis：fork出一个子进程，子进程中的数据是和父进程相同
     * 模拟：将原Map中的数据复制到另一个Map中，并将引用数改为2
     * @param redisData
     * @param copy
     */
    private static void fork(HashMap<String, Value> redisData, HashMap<String, Value> copy) {
        Iterator<Map.Entry<String, Value>> iterator = redisData.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Value> item = iterator.next();
            //将引用数改为2
            item.getValue().setRef(2);
            //将引用指向原地址
            copy.put(item.getKey(),item.getValue());
        }
    }


}
