package indi.w4xj.juc.casandaba.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.juc.casandaba.code
 * @Classname AtomicReferenceTest
 * @Description TODO
 * @Date 2021/2/12 12:22
 * @Created by IntelliJ IDEA
 */
public class AtomicReferenceTest {
    public static void main(String[] args) {
        User a = new User("A",12);
        User b = new User("B",14);


        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(a);
        /*
        打印：
            update result = true, user = User(name=B, age=14)
            update result = false, user = User(name=B, age=14)
         */
        System.out.println("update result = " + atomicReference.compareAndSet(a,b) + ", user = " + atomicReference.get().toString());
        System.out.println("update result = " + atomicReference.compareAndSet(a,b) + ", user = " + atomicReference.get().toString());
    }
}

@Getter
@ToString
@AllArgsConstructor
//这里需安装lombok,且引入lombok.jar
class User {
    String name;
    int age;
}