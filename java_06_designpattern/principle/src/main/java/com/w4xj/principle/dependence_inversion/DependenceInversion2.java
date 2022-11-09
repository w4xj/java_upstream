package com.w4xj.principle.dependence_inversion;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package com.w4xj.principle.dependence_inversion
 * @Classname DependenceInversion2
 * @Description TODO
 * @Date 2022/11/9 22:07
 * @Created by IntelliJ IDEA
 */
public class DependenceInversion2 {
    public static void main(String[] args) {
        /**
         * 依赖的三种方式
         * 1、接口参数传递
         * public void operation(I_A a){
         *     a.xxx()
         * }
         *
         * 2、构造方法传递
         * Main main = new Main(a);
         * public void method{
         *    a.xxx()
         * }
         *
         * 3、setter方式传递
         * Main main = new Main();
         * main.set(a);
         * public void method{
         *    a.xxx()
         * }
         */


        Person2 person2 = new Person2();
        Email2 email2 = new Email2();
        Message2 message2 = new Message2();
        person2.receive(email2);
        person2.receive(message2);
    }
}

interface IReceiver{
    String getInfo();
}
class Email2 implements IReceiver{
    @Override
    public String getInfo() {
        return "email";
    }
}

class Message2 implements IReceiver{
    @Override
    public String getInfo() {
        return "message";
    }
}

class Person2{
    public void receive(IReceiver iReceiver){
        System.out.println(iReceiver.getInfo());
    }
}







