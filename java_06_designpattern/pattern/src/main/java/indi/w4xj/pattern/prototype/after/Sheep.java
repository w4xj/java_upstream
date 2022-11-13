package indi.w4xj.pattern.prototype.after;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author lemon joker
 * @Project java_upstream
 * @Package indi.w4xj.pattern.prototype.after
 * @Classname Sheep
 * @Description 会当凌绝顶 一览众山小
 * @Date 2022/11/13 15:08
 * @Created by IntelliJ IDEA
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sheep implements Cloneable{
    private String name;
    private int age;

    /**
     * 克隆该实例，使用默认的clone
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        }catch (CloneNotSupportedException e){
            System.out.println(e.getMessage());
        }
        return sheep;
    }
}
