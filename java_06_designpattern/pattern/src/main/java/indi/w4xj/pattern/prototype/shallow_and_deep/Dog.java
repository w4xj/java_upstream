package indi.w4xj.pattern.prototype.shallow_and_deep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.prototype.shallow_and_deep
 * @Classname Dog
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 15:55
 * @Created by IntelliJ IDEA
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Dog implements Cloneable{
    String name;
    Owner owner;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
