package indi.w4xj.boxing;

/**
 * @Author Yolo Cheung
 * @Project java_upstream
 * @Package indi.w4xj.boxing
 * @Classname AutoboxingAndUnboxing
 * @Description TODO
 * @Date 2022/2/18 10:47 上午
 * @Created by IntelliJ IDEA
 */
public class AutoboxingAndUnboxing {
    public static void main(String[] args) {
        double d1=0.8900000000000006;
        double d2=0.8900000000000006;
        System.out.println("d1==d2:" + (d1==d2)); //返回结果true
        double d3=128.0;
        double d4=128.0;
        System.out.println("d3==d4:" + (d3==d4)); //返回结果true

        Double D1=0.8900000000000006;
        Double D2=0.8900000000000006;
        System.out.println("D1==D2:" + (D1==D2));//返回结果false
        System.out.println("D1==0.8900000000000006:" + (D1==0.8900000000000006));//返回结果true


        Integer I1=127;
        Integer I2=127;
        System.out.println("I1==I2:" + (I1==I2));//返回结果true
        Integer I3=128;
        Integer I4=128;
        System.out.println("I3==I4:" + (I3==I4));//返回结果false


        Float F1=1f;
        Float F2=1f;
        System.out.println("F1==F2:" + (F1==F2));//返回结果false

        Short S1=1;
        Short S2=1;
        System.out.println("S1==S2:" + (S1==S2));//返回结果true

        Short S3=128;
        Short S4=128;
        System.out.println("S3==S4:" + (S3==S4));//返回结果false

        Byte B1=2;
        Byte B2=2;
        System.out.println("B1==B2:" + (B1==B2));//返回结果true

        char c1='a';
        char c2='a';
        System.out.println("c1==c2:" + (c1==c2));//返回结果true
        System.out.println("一:" + ((int)'一'));
        System.out.println("啊:" + ((int)'啊'));
        System.out.println("龘:" + ((int)'龘'));

        Long L1=127l;
        Long L2=127l;
        System.out.println("L1==L2:" + (L1==L2));//返回结果true
        Long L3=128l;
        Long L4=128l;
        System.out.println("L3==L4:" + (L3==L4));//返回结果false

    }
}
