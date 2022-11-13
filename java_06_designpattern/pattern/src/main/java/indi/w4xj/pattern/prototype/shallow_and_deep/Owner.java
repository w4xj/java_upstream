package indi.w4xj.pattern.prototype.shallow_and_deep;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.prototype.shallow_and_deep
 * @Classname Owner
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 15:56
 * @Created by IntelliJ IDEA
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Owner  implements Cloneable, Serializable {
    String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
