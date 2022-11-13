package indi.w4xj.jvm.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname ClassLoaderByHand
 * @Description 
 * @Date 2021/4/28 23:01
 * @Created by IntelliJ IDEA
 */
public class ClassLoaderByHand {
    public static void main(String[] args) throws ClassNotFoundException{
        Class<?> clazz = ClassLoaderByHand.class.getClassLoader().loadClass("indi.w4xj.jvm.code.A_Class");
        System.out.println(clazz.getName());
    }
}

class A_Class{

}
