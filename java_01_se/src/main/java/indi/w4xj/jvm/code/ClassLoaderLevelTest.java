package indi.w4xj.jvm.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname ClassLoaderLevelTest
 * @Description 
 * @Date 2021/4/25 23:02
 * @Created by IntelliJ IDEA
 */
public class ClassLoaderLevelTest {
    public static void main(String[] args) {
        //null
        System.out.println(String.class.getClassLoader());
        //null
        System.out.println(sun.awt.HKSCS.class.getClassLoader());
        //ExtClassLoader
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        //AppClassLoader
        System.out.println(ClassLoaderLevelTest.class.getClassLoader());
        //null
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());
        //null
        System.out.println(ClassLoaderLevelTest.class.getClassLoader().getClass().getClassLoader());

//        System.out.println(new T006_MSBClassLoader().getParent());
        //AppClassLoader
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
