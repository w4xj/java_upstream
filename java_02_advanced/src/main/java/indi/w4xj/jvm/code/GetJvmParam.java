package indi.w4xj.jvm.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname GetJvmParam
 * @Description TODO
 * @Date 2021/2/15 15:30
 * @Created by IntelliJ IDEA
 */
public class GetJvmParam {
    public static void main(String[] args) {
        //初始堆大小  默认=机身内存/64    16G/64 ≈ 250M
        System.out.println("Xms ≈ " + Runtime.getRuntime().totalMemory()/(1024 * 1024) + "M");

        //最大堆大小  默认=机身内存/4      16G/4 ≈ 4000M
        System.out.println("Xmx ≈ " + Runtime.getRuntime().maxMemory()/(1024 * 1024) + "M");
    }
}
