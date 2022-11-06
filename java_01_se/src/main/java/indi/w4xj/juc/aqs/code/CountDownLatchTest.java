package indi.w4xj.juc.aqs.code;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CountDownLatch;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.aqs.code
 * @Classname CountDownLatchTest
 * @Description TODO
 * @Date 2021/2/14 12:35
 * @Created by IntelliJ IDEA
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1 ; i <= 6 ; i++){
            new Thread(() ->{
                System.out.println(Thread.currentThread().getName() + "国被灭");
                countDownLatch.countDown();
            },CountryEnum.get(i).getCountryName()).start();
        }


        try { countDownLatch.await(); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println(Thread.currentThread().getName() + ":秦灭六国~~");
        /*
        打印：
            齐国被灭
            楚国被灭
            燕国被灭
            韩国被灭
            魏国被灭
            赵国被灭
            main:秦灭六国~~
         */
    }
}

//安装lombok并引入jar包
@Getter
@AllArgsConstructor
enum CountryEnum{
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),FOUR(4,"韩"),FIVE(5,"赵"),SIX(6,"魏");
    private int countryId;
    private String countryName;

    public static CountryEnum get(Integer id){
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum countryEnum : values()) {
            if(countryEnum.getCountryId() == id){
                return countryEnum;
            }
        }
        return null;
    }
}