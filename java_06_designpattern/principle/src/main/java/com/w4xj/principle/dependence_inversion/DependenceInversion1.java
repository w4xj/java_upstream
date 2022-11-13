package com.w4xj.principle.dependence_inversion;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package com.w4xj.principle.dependence_inversion
 * @Classname DependenceInversion1
 * @Description 
 * @Date 2022/11/9 22:00
 * @Created by IntelliJ IDEA
 */
public class DependenceInversion1 {
    public static void main(String[] args) {
        Person1 person1 = new Person1();
        person1.receive(new Email1());
    }

}
class Email1{
    public String getInfo(){
        return "hello emial";
    }
}

//Person接受消息
//1、简单，容易实现
//2、如果我们要新增信息种类，那么就需要新增入参类和接受方法
class Person1{
    public void receive(Email1 email1){
        System.out.println(email1.getInfo());
    }
}
