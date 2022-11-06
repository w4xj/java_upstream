package indi.w4xj.jvm.code;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.jvm.code
 * @Classname TLABTest
 * @Description TODO
 * @Date 2021/5/15 9:15
 * @Created by IntelliJ IDEA
 */
public class TLABTest {
    //参数：-XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB
    //User u;
    class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    void alloc(int i) {
        new User(i, "name " + i);
    }

    public static void main(String[] args) {
        TLABTest t = new TLABTest();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000_0000; i++) {
            t.alloc(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        //for(;;);
    }
}

