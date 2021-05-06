package indi.w4xj.jvm.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname ParentAndChild
 * @Description TODO
 * @Date 2021/4/28 22:19
 * @Created by IntelliJ IDEA
 */
public class ParentAndChild {
    public static void main(String[] args) {
        //AppClassLoader
        System.out.println(ParentAndChild.class.getClassLoader());
        //null
        System.out.println(ParentAndChild.class.getClassLoader().getClass().getClassLoader());
        //ExtClassLoader
        System.out.println(ParentAndChild.class.getClassLoader().getParent());
        //null
        System.out.println(ParentAndChild.class.getClassLoader().getParent().getParent());
        //NullPointerException
        System.out.println(ParentAndChild.class.getClassLoader().getParent().getParent().getParent());
    }
}
