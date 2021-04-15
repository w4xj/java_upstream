package indi.w4xj.jmh.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jmh.code
 * @Classname JmhBizClass
 * @Description TODO
 * @Date 2021/4/15 21:50
 * @Created by IntelliJ IDEA
 */
public class JmhBizClass {
    static List<Integer> nums = new ArrayList<>();
    static {
        Random r = new Random();
        for (int i = 0; i < 10000; i++) nums.add(1000000 + r.nextInt(1000000));
    }

    static void foreach() {
        nums.forEach(v->isPrime(v));
    }

    static void parallel() {
        nums.parallelStream().forEach(JmhBizClass::isPrime);
    }

    static boolean isPrime(int num) {
        for(int i=2; i<=num/2; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
