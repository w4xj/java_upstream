package com.w4xj.principle.interface_segregation;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package com.w4xj.principle.interface_segregation
 * @Classname InterfaceSegregation2
 * @Description 
 * @Date 2022/11/9 21:39
 * @Created by IntelliJ IDEA
 */
public class InterfaceSegregation2 {
    public static void main(String[] args) {
        //将接口进行拆分
        A2 a2 = new A2();
        a2.operation1();
        a2.operation2();
        a2.operation3();

        B2 b2 = new B2();
        b2.operation2();
        b2.operation3();
        b2.operation4();
    }
}

interface Interface2_1{
    void operation1();
}
interface Interface2_2{
    void operation2();
    void operation3();
}
interface Interface2_3{
    void operation4();
}

class A2 implements Interface2_1, Interface2_2{
    public void operation1() {}
    public void operation2() {}
    public void operation3() {}

}
class B2 implements Interface2_2, Interface2_3{
    public void operation2() {}
    public void operation3() {}
    public void operation4() {}
}


