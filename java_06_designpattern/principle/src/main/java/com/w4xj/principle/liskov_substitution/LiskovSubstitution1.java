package com.w4xj.principle.liskov_substitution;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package com.w4xj.principle.liskov_substitution
 * @Classname LiskovSubstitution1
 * @Description 
 * @Date 2022/11/10 20:30
 * @Created by IntelliJ IDEA
 */
public class LiskovSubstitution1 {
    public static void main(String[] args) {
        A a = new A();
        A ab =new B();

        System.out.println(a.func1(3, 1));
        System.out.println(ab.func1(3, 1));
    }
}

class A{
    public int func1(int x, int y){
        return x-y;
    }
}

//增加了A的功能，但是无意间把func1重写了
class B extends A{
    public int func1(int x, int y){
        return x+y;
    }
    public int func2(int x, int y){
        return func1(x,y)*100;
    }
}
