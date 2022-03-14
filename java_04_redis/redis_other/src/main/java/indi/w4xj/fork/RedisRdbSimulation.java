package indi.w4xj.fork;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


/**
 * @Author yolo cheung
 * @Project java_upstream
 * @Package indi.w4xj.fork
 * @Classname RedisRdbSimulation
 * @Description 模拟redis rdb持久化
 * @Date 2022/3/8 23:17
 * @Created by IntelliJ IDEA
 */
public class RedisRdbSimulation {

    //redis数据
    static HashMap<String, Value> redisData = new HashMap<>();
    static {
        //原始redis数据
        set("a", "abc");
        lPush("b", Arrays.asList(1,2,3));
        hSet("c", new HashMap<String, Object>(){{
            put("name", "zhangsan");
            put("age", 18);
            put("sex", "male");
        }});
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Value {
        //引用数量
        private int ref;
        //数据类型
        private Class<?> dataStructure ;
        //值
        private Object value;
    }

    public static void main(String[] args) {
        //副本，模拟子线程的引用
        HashMap<String, Value>  copy = new HashMap<>();
        //fork子进程，数据指向同一个内存区域
        fork(copy);
        //持久化
        persist(copy);
        //并发修改
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
                    lPush("b", Arrays.asList(finalI1));
                    hSet("c", new HashMap<String, Object>(){{
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
            System.out.println(Thread.currentThread().getName() + "：持久化开始---" + new Date());
            Iterator<Map.Entry<String, Value>> iterator = copy.entrySet().iterator();
            while (iterator.hasNext()){
                try {
                    Map.Entry<String, Value> item = iterator.next();
                    System.out.println(Thread.currentThread().getName() +"：写入---" + new Date() +"\nkey=" + item.getKey() + "\nvalue=" + item.getValue() + "\n");
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            copy.clear();
            System.out.println(Thread.currentThread().getName() + "：持久化完成---" + new Date()+"\n");
        }, "persistThread").start();
    }


    /**
     * 数据存进redis
     * @param key
     * @param value
     * @param T
     */
    private static void put(String key, Object value, Class<?> T) {
        Value original = redisData.get(key);
        //如果引用为2，则触发写时复制
        if(null != original && original.getRef() == 2){
            copyOnWrite(key, value, T);
        }else {
            redisData.put(key, new Value(1, T, value));
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
            System.out.println(Thread.currentThread().getName() + "：触发写时复制---" + new Date() + "\nkey[" + key + "]的值从"+ original.getValue() +"改为" + value + "\n");
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
     *
     * @param key
     * @return
     */
    private static String get(String key) {
        Value value = redisData.get(key);
        if(value.getValue() instanceof String){

        } else {

        }
        return null;
    }



    /**
     * 模拟list插入
     * @param key
     * @param value
     */
    private static void lPush(String key, List value) {
        if (value instanceof List){
            put(key, value, List.class);
        } else{
            throw new RuntimeException("只能放入List类型");
        }
    }

    /**
     * 模拟hash插入
     * @param key
     * @param value
     */
    private static void hSet(String key, Map value) {
        if (value instanceof Map){
            put(key, value, Map.class);
        } else{
            throw new RuntimeException("只能放入Map类型");
        }
    }


    /**
     * redis：fork出一个子进程，子进程中的数据是和父进程相同
     * 模拟：将原Map中的数据复制到另一个Map中，并将引用数改为2
     * @param copy
     */
    private static void fork(HashMap<String, Value> copy) {
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
