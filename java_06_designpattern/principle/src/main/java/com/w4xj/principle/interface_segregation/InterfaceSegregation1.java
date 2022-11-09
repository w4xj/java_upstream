package com.w4xj.principle.interface_segregation;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package com.w4xj.principle.interface_segregation
 * @Classname InterfaceSegregation1
 * @Description TODO
 * @Date 2022/11/9 21:39
 * @Created by IntelliJ IDEA
 */
public class InterfaceSegregation1 {
    public static void main(String[] args) {
        //A B只用到了一部分接口，但是实现了所有方法
        A1 a1 = new A1();
        a1.operation1();
        a1.operation2();
        a1.operation3();

        B1 b1 = new B1();
        b1.operation2();
        b1.operation3();
        b1.operation4();
    }
}

interface Interface1{
    void operation1();
    void operation2();
    void operation3();
    void operation4();
}

class A1 implements Interface1{
    public void operation1() {}
    public void operation2() {}
    public void operation3() {}
    public void operation4() {}
}
class B1 implements Interface1{
    public void operation1() {}
    public void operation2() {}
    public void operation3() {}
    public void operation4() {}
}


