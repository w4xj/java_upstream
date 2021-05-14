package indi.w4xj.jvm.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname InvokeDynamicTest
 * @Description TODO
 * @Date 2021/5/14 23:39
 * @Created by IntelliJ IDEA
 */
public class InvokeDynamicTest {
    public static void main(String[] args) {
        I i = C::n;
        I i2 = C::n;
        I i3 = C::n;
        I i4 = () -> {
            C.n();
        };
        System.out.println(i.getClass());
        System.out.println(i2.getClass());
        System.out.println(i3.getClass());
        System.out.println(i4.getClass());
        /**
         class indi.w4xj.jvm.code.InvokeDynamicTest$$Lambda$1/764977973
         class indi.w4xj.jvm.code.InvokeDynamicTest$$Lambda$2/668386784
         class indi.w4xj.jvm.code.InvokeDynamicTest$$Lambda$3/1329552164
         class indi.w4xj.jvm.code.InvokeDynamicTest$$Lambda$4/363771819
         */
        //for(;;) {I j = C::n;} //MethodArea <1.8 Perm Space (FGC不回收)
    }

    @FunctionalInterface
    public interface I {
        void m();
    }

    public static class C {
        static void n() {
            System.out.println("hello");
        }
    }
}