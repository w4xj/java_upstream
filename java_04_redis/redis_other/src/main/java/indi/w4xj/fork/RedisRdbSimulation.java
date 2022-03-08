package indi.w4xj.fork;

import lombok.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

    private static class Value {
        private int id;
        private String field1;
        private String field2;
        private String field3;

        public Value() {
        }

        public Value(int id, String field1, String field2, String field3) {
            this.id = id;
            this.field1 = field1;
            this.field2 = field2;
            this.field3 = field3;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getField1() {
            return field1;
        }

        public void setField1(String field1) {
            this.field1 = field1;
        }

        public String getField2() {
            return field2;
        }

        public void setField2(String field2) {
            this.field2 = field2;
        }

        public String getField3() {
            return field3;
        }

        public void setField3(String field3) {
            this.field3 = field3;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Value> copy = new HashMap<>();
        //原始redis数据
        HashMap<String, Value> redisData = new HashMap<String, Value>() {
            {
                put("a", new Value(1, "a1", "a2", "a3"));
                put("b", new Value(2, "b1", "b2", "b3"));
                put("c", new Value(3, "c1", "c2", "c3"));
                put("d", new Value(4, "d1", "d2", "d3"));
            }
        };

//        copy = redisData;
//        copy.putAll(redisData);
        copy = (HashMap)redisData.clone();

        Value a1 = redisData.get("a");
        Value a2 = copy.get("a");
        System.out.println(a1.hashCode());
        System.out.println(a2.hashCode());

//        new Thread(() -> {
//
//        }, "ForkThread").start();

    }
}
