package com.w4xj.principle.liskov_substitution;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package com.w4xj.principle.liskov_substitution
 * @Classname LiskovSubstitution2
 * @Description TODO
 * @Date 2022/11/10 20:46
 * @Created by IntelliJ IDEA
 */
public class LiskovSubstitution2 {
    public static void main(String[] args) {

        //子类避免重写父类的方法，类之间尽量使用组合、聚合、依赖关系
        AA a = new AA();
        BB b = new BB();
        System.out.println(a.func1(3, 1));
        System.out.println(b.func1(3, 1));
        System.out.println(b.func2(3, 1));
        System.out.println(b.func3(3, 1));

    }
}
class Base{}

class AA extends Base{
    public int func1(int x, int y){
        return x-y;
    }
}

//增加了A的功能，但是无意间把func1重写了
class BB extends Base{
    private A a = new A();
    public int func1(int x, int y){
        return x+y;
    }
    public int func2(int x,int y){
        return func1(x,y) * 100;
    }

    public int func3(int x, int y){
        return this.a.func1(x, y);
    }
}
