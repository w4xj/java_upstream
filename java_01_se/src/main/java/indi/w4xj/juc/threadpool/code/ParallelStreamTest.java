package indi.w4xj.juc.threadpool.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.threadpool.code
 * @Classname ParalleStreamTest
 * @Description 
 * @Date 2021/4/13 23:34
 * @Created by IntelliJ IDEA
 */
public class ParallelStreamTest {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        Random r = new Random();
        for(int i=0; i<10000; i++) nums.add(1000000 + r.nextInt(1000000));

        //System.out.println(nums);

        long start = System.currentTimeMillis();
        nums.forEach(v->isPrime(v));
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        start = System.currentTimeMillis();
        nums.parallelStream().forEach(ParallelStreamTest::isPrime);
        end = System.currentTimeMillis();

        System.out.println(end - start);
    }

    static boolean isPrime(int num) {
        for(int i=2; i<=num/2; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
